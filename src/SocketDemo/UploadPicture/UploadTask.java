package SocketDemo.UploadPicture;

import java.io.*;
import java.net.Socket;

public class UploadTask implements Runnable {
    private static final int SIZE = 1024 * 1024 * 2;
    private Socket s;
    public UploadTask(Socket s){
        this.s = s;
    }

    public void run(){
        int count = 0;
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + ".......connected");

        try {
            InputStream in = s.getInputStream();
            File dir = new File("I:\\IDEA\\Test\\SocketTest\\Upload");
            if(!dir.exists()){
                dir.mkdirs();
            }

            File file = new File(dir,ip + ".jpg");
            while(file.exists()){
                file = new File(dir, ip+"("+(++count)+").jpg");
            }

            FileOutputStream fos = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = in.read(buf)) != -1){
                fos.write(buf, 0 ,len);
                if(file.length() > SIZE){
                    System.out.println(ip + "文件过大");
                    fos.close();
                    s.close();
                }
            }

            OutputStream out = s.getOutputStream();
            out.write("上传成功".getBytes());

            fos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}