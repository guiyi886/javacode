package javaLow.实验六.first;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient2 {
    public static void main(String[] args) {
        try {
            // 创建UDP套接字
            DatagramSocket socket = new DatagramSocket(9878);

            // 获取服务器地址和端口
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            // 启动一个线程接收来自服务器的消息
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        // 接收服务器的消息
                        byte[] receiveData = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        socket.receive(receivePacket);

                        // 将接收到的数据转换为字符串并打印
                        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                        System.out.println("\n服务器消息: " + message);
                        System.out.print("输入给服务器的消息: ");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // 发送消息到服务器
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("输入给服务器的消息: ");

                // 从控制台读取用户输入的消息
                String sendMessage = scanner.nextLine();

                // 将消息转换为字节数组并发送到服务器
                byte[] sendData = sendMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
