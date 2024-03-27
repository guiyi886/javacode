package javaLow.实验六.first;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // 创建UDP套接字并绑定端口
            DatagramSocket socket = new DatagramSocket(9876);

            // 启动一个线程接收来自客户端的消息
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        // 接收客户端的消息
                        byte[] receiveData = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        socket.receive(receivePacket);

                        // 将接收到的数据转换为字符串并打印
                        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                        System.out.println("\n客户端" + (receivePacket.getPort() - 9876) + "消息: " + message);
                        System.out.print("输入给客户端的消息(格式为:客户id 消息): ");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // 发送消息给客户端
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("输入给客户端的消息(格式为:客户id 消息): ");

                // 从控制台读取用户输入的消息
                Integer sendClient = scanner.nextInt();
                String sendMessage = scanner.next();

                // 将消息转换为字节数组并发送到客户端
                byte[] sendData = sendMessage.getBytes();
                InetAddress clientAddress = InetAddress.getByName("localhost");
                int clientPort = 9876 + sendClient;
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
