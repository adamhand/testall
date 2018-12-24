package UDPThread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive implements Runnable {
    private DatagramSocket ds;

    public UDPReceive(DatagramSocket ds){
        this.ds = ds;
    }

    public void run(){
        try {
            while(true){
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);

                ds.receive(dp);

                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(),0,dp.getLength());
                if("886".equals(text)){
                    System.out.println(ip+"退出聊天室");
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
