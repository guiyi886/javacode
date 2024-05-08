package javaInternet.exp3_3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author guiyi
 * @Date 2024/5/8 下午10:26:41
 * @ClassName javaInternet.exp3_3.URLAnalyzer
 * @function -->
 */
public class URLAnalyzer {
    public static void main(String[] args) {
        // 获取用户输入的URL
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入URL网址：");
        String urlString = scanner.nextLine();

        try {
            // 创建URL对象
            URL url = new URL(urlString);

            // 获取各组成部分
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String path = url.getPath();
            String query = url.getQuery();
            String userInfo = url.getUserInfo();

            // 显示输出各组成部分
            System.out.println("协议(protocol)：" + protocol);
            System.out.println("主机(host)：" + host);
            System.out.println("端口(port)：" + (port == -1 ? "未指定" : port));
            System.out.println("路径(path)：" + (path.isEmpty() ? "未指定" : path));
            System.out.println("查询参数(query)：" + (query == null ? "无" : query));
            System.out.println("用户信息(userInfo)：" + (userInfo == null ? "无" : userInfo));

        } catch (MalformedURLException e) {
            System.out.println("输入的URL格式不正确：" + e.getMessage());
        }
    }
}
