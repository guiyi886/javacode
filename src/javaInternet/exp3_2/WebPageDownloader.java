package javaInternet.exp3_2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author guiyi
 * @Date 2024/5/8 下午10:14:14
 * @ClassName javaInternet.exp3_2.WebPageDownloader
 * @function -->
 */
public class WebPageDownloader {
    public static void main(String[] args) {
        try {
            // 获取用户输入的URL网址
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("请输入要下载的网页URL：");
            String urlStr = reader.readLine();

            // 创建URL对象
            URL url = new URL(urlStr);

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方式
            connection.setRequestMethod("GET");

            // 获取输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // 创建保存网页内容的StringBuilder对象
            StringBuilder content = new StringBuilder();
            String inputLine;

            // 逐行读取网页内容并保存到StringBuilder中
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                content.append("\n");
            }
            in.close();

            // 在控制台显示网页内容
            System.out.println("网页内容如下：");
            System.out.println(content.toString());

            // 保存网页内容为HTML文件
            saveHTMLFile(content.toString(), "D:\\downloaded_page.html");

            System.out.println("网页已成功下载并保存为HTML文件。");

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
