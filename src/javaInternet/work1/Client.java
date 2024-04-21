package javaInternet.work1;


import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8081);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(new FileWriter("D:\\ClientData.txt"), true); // 别忘了true--立即发送缓冲区内容
             PrintWriter printWriter = new PrintWriter(new PrintWriter(socket.getOutputStream()), true)) {
            String line;
            int flag = 1;
            while ((line = serverReader.readLine()) != null) {
                System.out.println("客户端接收消息：" + line);
                line = flag + "：" + line;
                flag++;

                writer.println(line);
                printWriter.println(line);
                System.out.println("存入并发回客户端消息：" + line);
            }
            serverReader.close();
            writer.close();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
