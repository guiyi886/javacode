package javaInternet.exp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public static void main(String[] args) {
        try {
            // 发送GET请求
            URL url = new URL("http://localhost:8080/index.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            printResponse(connection);

            // 发送POST请求
            url = new URL("http://localhost:8080/");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            os.write("POST请求体内容".getBytes());
            os.flush();
            os.close();
            printResponse(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResponse(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        System.out.println("响应码: " + responseCode);

        // 打印响应头
        connection.getHeaderFields().forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine).append("\n");
        }
        in.close();
        System.out.println("响应内容: " + response.toString());
    }
}
