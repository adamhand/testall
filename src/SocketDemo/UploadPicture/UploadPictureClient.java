package SocketDemo.UploadPicture;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadPictureClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",10006);
            FileInputStream fis = new FileInputStream("I:\\IDEA\\Test\\SocketTest\\mingren.jpg");
            OutputStream out = socket.getOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = fis.read(buf)) != -1){
                out.write(buf,0,buf.length);
            }

            socket.shutdownOutput();

            InputStream in = socket.getInputStream();
            byte[] bufIn = new byte[1024];
            int lenIn = in.read(bufIn);
            String text = new String(buf,0,lenIn);
            System.out.println(text);

            fis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
