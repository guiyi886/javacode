package javaInternet.exp2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP客户端程序，用于与服务器进行通信
 */
public class TCPClient2 {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost"; // 服务器IP地址
        final int SERVER_PORT = 8888; // 服务器端口号
        Scanner scanner = new Scanner(System.in); // 用于从控制台读取用户输入

        try {
            while (true) {
                // 创建Socket连接服务器
                Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                // 创建输入流，用于从服务器接收消息
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 创建输出流，用于向服务器发送消息
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // 用户输入消息
                System.out.print("Input your message: ");
                String message = scanner.next();
                // 发送消息给服务器
                writer.println(message);
                System.out.println("Sent to server: " + message);

                // 接收服务器返回的消息
                String response = reader.readLine();
                System.out.println("Received from server: " + response + "\n");

                // 关闭Socket连接
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
