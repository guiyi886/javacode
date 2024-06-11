package javaInternet.exp4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public static void main(String[] args) {
        try {
            // 发送GET请求
            URL url = new URL("http://localhost:8080/index.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            saveResponse(connection, "GET");

            // 发送HEAD请求
            url = new URL("http://localhost:8080/");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            saveResponse(connection, "HEAD");

            // 发送POST请求
            url = new URL("http://localhost:8080/");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            os.write("POST请求体内容".getBytes());
            os.flush();
            os.close();
            saveResponse(connection, "POST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveResponse(HttpURLConnection connection, String requestType) throws IOException {
        int responseCode = connection.getResponseCode();
        System.out.println("响应码: " + responseCode);
        // 打印响应头
        connection.getHeaderFields().forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        // 获取响应内容类型
        String contentType = connection.getHeaderField("Content-Type");
        // 获取响应体长度
        int contentLength = connection.getContentLength();
        // 获取响应体输入流
        InputStream inputStream = connection.getInputStream();

        // 创建目录
        File directory = new File("./src/javaInternet/exp4/response/" + requestType);
        if (!directory.exists()) {
            directory.mkdirs(); // 创建目录及其父目录
        }

        if (!"HEAD".equals(connection.getRequestMethod())) {
            // 创建文件
            File file = new File(directory, "response" + System.currentTimeMillis() + getFileExtension(contentType));
            FileOutputStream outputStream = new FileOutputStream(file);

            // 保存响应内容到文件
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // 关闭流
            inputStream.close();
            outputStream.close();

            System.out.println("响应内容已保存到：" + file.getAbsolutePath());
            System.out.println();
        } else {
            System.out.println("HEAD请求无响应资源\n");
        }
    }

    private static String getFileExtension(String contentType) {
        if (contentType.contains("text/html")) {
            return ".html";
        } else if (contentType.contains("image/jpeg")) {
            return ".jpeg";
        } else if (contentType.contains("image/png")) {
            return ".png";
        } else if (contentType.contains("application/javascript")) {
            return ".js";
        } else if (contentType.contains("text/css")) {
            return ".css";
        } else {
            return "";
        }
    }
}
