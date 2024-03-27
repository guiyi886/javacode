package javaLow.实验六.second;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HttpDownloadServer {
    public static void main(String[] args) {
        try {
            // 创建远程对象实例
            javaLow.实验六.second.HttpDownloadService downloadService = new javaLow.实验六.second.HttpDownloadServiceImpl();

            // 注册远程对象
            LocateRegistry.createRegistry(1099);
            Naming.rebind("HttpDownloadService", downloadService);

            System.out.println("Server is ready to download HTML!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

