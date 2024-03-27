package javaLow.storage.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socketAtServer = null;
        DataOutputStream out = null;
        DataInputStream in = null;

        try {
            server = new ServerSocket(4333);
        } catch (IOException e) {
            System.out.println("SERVER ERROR!" + e);
        }

        try {
            socketAtServer = server.accept();
            in = new DataInputStream(socketAtServer.getInputStream());
            out = new DataOutputStream(socketAtServer.getOutputStream());
            while (true) {
                int m = 0;
                m = in.readInt();
                out.writeInt(m * 2);
                System.out.println("RECEIVED:" + m);
                Thread.sleep(500);
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {

        }
    }
}
