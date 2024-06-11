package javaInternet.exp4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {

    // 定义服务器监听的端口号
    private static final int PORT = 8080;
    // 定义Web根目录的相对路径
    private static final String WEB_ROOT = "./src/javaInternet/exp4/resources";

    public static void main(String[] args) {
        // 创建一个固定大小的线程池，大小为10
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("服务器已启动，监听端口: " + PORT);
            while (true) {
                // 监听客户端连接
                Socket clientSocket = serverSocket.accept();
                // 每当有客户端连接时，创建一个新的客户端处理线程
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

                // 读取客户端的请求行
                String requestLine = reader.readLine();
                if (requestLine == null || requestLine.isEmpty()) return;

                // 分析请求行
                String[] requestParts = requestLine.split(" ");
                if (requestParts.length < 3) return;

                String method = requestParts[0]; // 请求方法，例如GET或POST
                String fileRequested = ""; // 请求的文件路径

                // 根据请求方法决定请求的文件
                if ("GET".equals(method)) {
                    fileRequested = "/index.html";
                } else if ("POST".equals(method)) {
                    fileRequested = "/photo.jpeg";
                }

                // 创建文件对象
                File file = new File(WEB_ROOT, fileRequested);
                if (file.exists()) {
                    // 获取文件类型
                    String contentType = getContentType(fileRequested);
                    // 获取文件长度
                    int contentLength = (int) file.length();

                    // 向客户端发送HTTP响应头
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

                    // 如果不是HEAD方法，则发送文件内容
                    if (!method.equals("HEAD")) {
                        try (FileInputStream fileIn = new FileInputStream(file)) {
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            // 读取文件并写入到输出流
                            while ((bytesRead = fileIn.read(buffer)) != -1) {
                                output.write(buffer, 0, bytesRead);
                            }
                        }
                    }
                } else {
                    // 文件未找到，返回404错误
                    writer.println("HTTP/1.1 404 Not Found");
                    writer.println("Content-Type: text/html");
                    writer.println();
                    writer.println("<html><body><h1>File Not Found</h1></body></html>");
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭Socket连接
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 根据文件扩展名返回相应的MIME类型
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
