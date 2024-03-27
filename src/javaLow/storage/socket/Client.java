package javaLow.storage.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socketAtClient;
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            socketAtClient = new Socket("localhost", 4333);
            in = new DataInputStream(socketAtClient.getInputStream());
            out = new DataOutputStream(socketAtClient.getOutputStream());
            out.writeInt(1);
            while (true) {
                int m2 = 0;
                m2 = in.readInt();
                out.writeInt(m2);
                System.out.println("Client received" + m2);
                Thread.sleep(500);
            }
        } catch (Exception e) {

        }
    }
}
