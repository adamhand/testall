package IO.FileOutPutSreamDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void WriteDemo(String filePath, String data){
        FileOutputStream fos = null;
        try {
            //1.根据文件路径创建输出流
            fos = new FileOutputStream(filePath);
            //2.将字符串转化为数组并写入
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        String filePath = "D:\\Prom\\testAll\\src\\IO\\FileOutPutSreamDemo\\WriteDemo.txt";

        WriteDemo(filePath, "FileOutPutStream:" + "WriteDemo");
    }
}
