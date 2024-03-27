package javaLow.实验六.second;

import java.rmi.Naming;

public class HttpDownloadClient {
    public static void main(String[] args) {
        try {
            // 查找远程对象
            javaLow.实验六.second.HttpDownloadService downloadService = (javaLow.实验六.second.HttpDownloadService) Naming.lookup("rmi://localhost/HttpDownloadService");

            // 调用远程方法
            String url = "https://www.baidu.com";
            String htmlContent = downloadService.downloadHtml(url);

            System.out.println("HTML 内容来自" + url + ":\n" + htmlContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
