package javaInternet.exp2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedTCPServer {

    public static void main(String[] args) {
        final int PORT = 8888;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");

            // 服务器循环等待客户端连接
            while (true) {
                // 等待客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // 创建一个新线程来处理客户端请求
                Thread clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 客户端处理线程
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (
                    // 从客户端Socket获取输入流，并包装为BufferedReader
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // 从客户端Socket获取输出流，并包装为PrintWriter
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String inputLine;
                // 循环读取客户端发送的消息
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println("Received from client: " + inputLine + "\n");

                    // 将接收到的消息转换为大写
                    String response = inputLine.toUpperCase();

                    // 将处理后的消息发送给客户端
                    writer.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭客户端连接
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
