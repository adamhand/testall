package IO.FileInputStreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static String demoRead(String filePath){
        FileInputStream fis = null;
        String result = null;
        try {
            //1.根据path路径数实例化一个输入流对象
            fis = new FileInputStream(filePath);
            //2.返回这个流中可以被读的剩下的bytes字节的估计值
            int size = fis.available();
            //3.根据估计值创建缓冲数组
            byte[] buf = new byte[size];
            //4.将数据读入缓冲数组
            fis.read(buf);
            //5.将读到的数据创建成一个字符串，用于返回
            result = new String(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String filePath = "D:\\Prom\\testAll\\src\\IO\\FileInputStreamDemo\\demoRead.txt";
        String result = demoRead(filePath);
        System.out.println(result);
    }
}
