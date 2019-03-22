package SocketDemo.TCPTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",10002);
            OutputStream out = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(out);
//            out.write("TCP演示开始！".getBytes());
            printWriter.write("TPC演示开始");
            printWriter.flush();
            InputStream in = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String text = new String(buf,0,len);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
