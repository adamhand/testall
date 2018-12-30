package SocketDemo.UDPTest;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceive {
    public static void main(String[] args) {
        System.out.println("Receive is staring");

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(10000);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            while(true){
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);

                ds.receive(dp);

                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(),0,dp.getLength());
                if("886".equals(text)){
                    break;
                }

                System.out.println(ip+":"+port+":"+text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ds.close();
    }
}

/*
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

    public static void main(String[] args) throws IOException {

        System.out.println("接收端启动......");


        //1,建立udp socket服务。
        DatagramSocket ds = new DatagramSocket(10000);

        while(true){

            //2,创建数据包。
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);

            //3,使用接收方法将数据存储到数据包中。
            ds.receive(dp);//阻塞式的。

            //4，通过数据包对象的方法，解析其中的数据,比如，地址，端口，数据内容。
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            String text = new String(dp.getData(),0,dp.getLength());

            System.out.println(ip+":"+port+":"+text);


        }
        //5,关闭资源。
//		ds.close();


    }


}*/