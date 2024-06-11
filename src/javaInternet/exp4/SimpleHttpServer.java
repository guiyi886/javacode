package javaInternet.exp4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {

    private static final int PORT = 8080;
    private static final String WEB_ROOT = "./src/javaInternet/exp4/resources"; // 使用相对路径

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("服务器已启动，监听端口: " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                 PrintWriter writer = new PrintWriter(output)) {

                String requestLine = reader.readLine();
                if (requestLine == null || requestLine.isEmpty()) return;

                String[] requestParts = requestLine.split(" ");
                if (requestParts.length < 3) return;

                String method = requestParts[0];
                String fileRequested = "";
                if ("GET".equals(method)) {
                    fileRequested = "/index.html";
                } else if ("POST".equals(method)) {
                    fileRequested = "/photo.jpeg";
                }

                File file = new File(WEB_ROOT, fileRequested);
                if (file.exists()) {
                    String contentType = getContentType(fileRequested);
                    int contentLength = (int) file.length();

                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: " + contentType);
                    writer.println("Content-Length: " + contentLength);
                    writer.println("Date: " + new Date());
                    writer.println("Server: Simple Java HTTP Server");

                    // 设置Cookie，保存用户IP地址
                    String userIp = socket.getInetAddress().getHostAddress();
                    writer.println("Set-Cookie: user=" + userIp + "; Path=/; HttpOnly");

                    writer.println();
                    writer.flush();

                    if (!method.equals("HEAD")) {
                        try (FileInputStream fileIn = new FileInputStream(file)) {
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = fileIn.read(buffer)) != -1) {
                                output.write(buffer, 0, bytesRead);
                            }
                        }
                    }
                } else {
                    writer.println("HTTP/1.1 404 Not Found");
                    writer.println("Content-Type: text/html");
                    writer.println();
                    writer.println("<html><body><h1>File Not Found</h1></body></html>");
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String getContentType(String fileRequested) {
            if (fileRequested.endsWith(".html")) {
                return "text/html";
            } else if (fileRequested.endsWith(".jpg") || fileRequested.endsWith(".jpeg")) {
                return "image/jpeg";
            } else if (fileRequested.endsWith(".png")) {
                return "image/png";
            } else if (fileRequested.endsWith(".js")) {
                return "application/javascript";
            } else if (fileRequested.endsWith(".css")) {
                return "text/css";
            } else {
                return "text/plain";
            }
        }
    }
}
