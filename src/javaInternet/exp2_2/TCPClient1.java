package javaInternet.exp2_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * TCP客户端程序，用于与服务器进行通信
 */
public class TCPClient1 {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int SERVER_PORT = 8888;
        final String SOURCE_FILE_PATH = "D:\\source1.txt";

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new FileReader(SOURCE_FILE_PATH));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            String line;
            while ((line = reader.readLine()) != null) {
                // 发送每一行内容给服务器
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
