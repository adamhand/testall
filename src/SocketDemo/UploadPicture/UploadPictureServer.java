package UploadPicture;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPictureServer {

    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(10006);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            Socket s = null;
            try {
                s = ss.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(new UploadTask(s)).start();
        }
    }
}
