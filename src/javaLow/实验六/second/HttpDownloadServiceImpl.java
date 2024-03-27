package javaLow.实验六.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HttpDownloadServiceImpl extends UnicastRemoteObject implements javaLow.实验六.second.HttpDownloadService {
    protected HttpDownloadServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String downloadHtml(String url) throws RemoteException {
        try {
            URL targetUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) targetUrl.openConnection();

            // 设置连接属性
            connection.setRequestMethod("GET");

            // 读取 HTML 内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            reader.close();
            return result.toString();
        } catch (Exception e) {
            throw new RemoteException("无法从该地址下载 HTML " + url, e);
        }
    }
}
