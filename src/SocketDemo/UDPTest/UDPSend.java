package UDPTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPSend {

    public static void main(String[] args) {
        System.out.println("Sending is starting!");

        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(ip);

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8888);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try {
            while((line = bufr.readLine()) != null){
                byte[] buf = line.getBytes();
//                DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.136.1"),10000);
                DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("127.0.0.1"),10000);
                ds.send(dp);
                if("886".equals(line)){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ds.close();
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend {

    public static void main(String[] args) throws IOException {

        System.out.println("发送端启动......");

        //1,udpsocket服务。使用DatagramSocket对象。
        DatagramSocket ds = new DatagramSocket(8888);


//		String str = "udp传输演示：哥们来了！";
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line=bufr.readLine())!=null){


            byte[] buf = line.getBytes();
            DatagramPacket dp =
                    new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),10000);//为什么只有127.0.0.1可以？
//                    new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.10.124"),10000);
//                    new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.136.1"),10000);
            ds.send(dp);

            if("886".equals(line))
                break;
        }

        //4，关闭资源。
        ds.close();


    }

}
*/