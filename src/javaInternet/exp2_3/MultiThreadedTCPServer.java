package javaInternet.exp2_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MultiThreadedTCPServer {
    private static final int PORT = 8888;
    private static final String SAFE_ABSTRACT_FILE = "D:\\SafeAbstract.txt";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
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
            // 记录连接日志
            Logger.logConnection(clientSocket);

            // 根据端口命名文件
            int clientPort = clientSocket.getPort();
            String clientFileName = "D:\\Client_" + clientPort + ".txt";

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(new FileWriter(clientFileName), true)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received from client: " + line);
                    // 写入到客户端专用的txt文件中
                    writer.println(line);
                }

                // 计算安全算法摘要并写入SafeAbstract.txt文件中
                calculateAndWriteSafeAbstract(clientFileName);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 计算安全算法摘要并写入SafeAbstract.txt文件中
        private void calculateAndWriteSafeAbstract(String fileName) {
            try {
                File file = new File(fileName);
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                FileInputStream fis = new FileInputStream(file);
                byte[] dataBytes = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(dataBytes)) != -1) {
                    md.update(dataBytes, 0, bytesRead);
                }
                byte[] mdBytes = md.digest();

                // 转换字节数组为十六进制字符串
                StringBuilder sb = new StringBuilder();
                for (byte mdByte : mdBytes) {
                    sb.append(Integer.toString((mdByte & 0xff) + 0x100, 16).substring(1));
                }
                String mdString = sb.toString();

                // 写入SafeAbstract.txt文件中
                synchronized (MultiThreadedTCPServer.class) {
                    PrintWriter writer = new PrintWriter(new FileWriter(SAFE_ABSTRACT_FILE, true));
                    writer.println(fileName + ": " + mdString);
                    writer.close();
                }
            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }
}
