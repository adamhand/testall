package UDPThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend implements Runnable{

    private DatagramSocket ds;
    public UDPSend(DatagramSocket ds){
        this.ds = ds;
    }

    public void run(){
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            System.out.println(hostName);

            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while((line = bufr.readLine()) != null){
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("127.0.0.1"),10001);
                ds.send(dp);
                if("886".equals(line)){
                    break;
                }
            }

            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
