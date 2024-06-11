package javaInternet.exp4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

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
            connection.setDoOutput(true); // 允许向服务器发送数据
            OutputStream os = connection.getOutputStream();
            os.write("POST请求体内容".getBytes()); // 发送POST请求体内容
            os.flush();
            os.close();
            saveResponse(connection, "POST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 保存服务器响应的方法
    private static void saveResponse(HttpURLConnection connection, String requestType) throws IOException {
        // 获取响应码
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

        if (!"HEAD".equals(connection.getRequestMethod())) { // HEAD请求没有响应体
            // 创建目录
            File directory = new File("./src/javaInternet/exp4/response/" + requestType);
            if (!directory.exists()) {
                directory.mkdirs(); // 创建目录及其父目录
            }

            Date date = new Date();
            // 创建文件，文件名为当前日期时间加上合适的扩展名
            File file = new File(directory,
                    (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate() + "-" + date.getHours()
                            + "-" + date.getMinutes() + "-" + date.getSeconds() + getFileExtension(contentType));
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

    // 根据Content-Type获取文件扩展名
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
