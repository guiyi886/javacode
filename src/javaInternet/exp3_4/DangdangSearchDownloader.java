package javaInternet.exp3_4;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DangdangSearchDownloader {
    public static void main(String[] args) {
        try {
            // 获取用户输入的搜索关键词
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("请输入商品搜索关键词：");
            String keyword = reader.readLine();

            // 构建搜索URL
            String searchUrl = "https://search.dangdang.com/?key=" + keyword;

            // 创建URL对象
            URL url = new URL(searchUrl);

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 获取输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GB2312"));

            // 创建保存网页内容的StringBuilder对象
            StringBuilder content = new StringBuilder();
            String inputLine;

            // 逐行读取网页内容并保存到StringBuilder中
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                content.append("\n");
            }
            in.close();

            // 将网页内容保存为HTML文件到D盘
            saveHTMLFile(content.toString(), "D:\\productResult.html");

            System.out.println("网页已成功保存为HTML文件。");
            System.out.println(content);

        } catch (IOException e) {
            System.out.println("下载网页时出现IO异常：" + e.getMessage());
        }
    }

    // 将网页内容保存为HTML文件
    private static void saveHTMLFile(String content, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("保存HTML文件时出现IO异常：" + e.getMessage());
        }
    }
}
