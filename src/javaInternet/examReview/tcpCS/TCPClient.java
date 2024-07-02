package javaInternet.examReview.tcpCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6666);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            System.out.println("请输入消息：");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("服务器响应：" + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

