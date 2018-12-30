package SocketDemo.TCPTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(10002);
            s = ss.accept();

            String ip = s.getInetAddress().getHostAddress();
            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];

            int len = in.read(buf);
            String text = new String(buf,0,len);
            System.out.println(ip+":"+text);

            OutputStream out = s.getOutputStream();
            out.write("收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ss.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
