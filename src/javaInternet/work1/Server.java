package javaInternet.work1;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("服务器启动！");

            while (true) {
                Socket clientSocker = serverSocket.accept();
                System.out.println("连接到客户端 " + clientSocker.getRemoteSocketAddress());

                BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\serverData.txt"));
                PrintWriter printWriter = new PrintWriter(clientSocker.getOutputStream(), true);
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocker.getInputStream()));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    printWriter.println(line);
                    System.out.println("发送客户端消息：" + line);
                    System.out.println("收到客户端消息：" + clientReader.readLine());
                }

                bufferedReader.close();
                printWriter.close();
                clientReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
