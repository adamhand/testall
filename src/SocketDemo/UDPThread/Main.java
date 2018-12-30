package SocketDemo.UDPThread;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {
        DatagramSocket send = null;
        DatagramSocket rece = null;
        try {
            send = new DatagramSocket();
            rece = new DatagramSocket(10001);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        new Thread(new UDPSend(send)).start();
        new Thread(new UDPReceive(rece)).start();
    }
}
