package IO.FileReaderWriterDemo;

import java.io.*;

public class FileReaderWriterDemo {
    public static void main(String[] args) {
        String fromPath = "D:\\Prom\\testAll\\src\\IO\\FileReaderWriterDemo\\0.txt";
        String toPath = "D:\\Prom\\testAll\\src\\IO\\FileReaderWriterDemo\\1.txt";

//        readWriteDemo_1(fromPath, toPath);
//        readWriteDemo_2(fromPath, toPath);
        readWriteDemo_3(fromPath, toPath);
    }

    /**
     * 直接读取写入的方式，效率低下，不建议使用。
     * @param fromPath
     * @param toPath
     */
    public static void readWriteDemo_1(String fromPath, String toPath){
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(fromPath);
            fw = new FileWriter(toPath);

            //直接读取
            int ch = 0;
            while((ch = fr.read()) != -1){
                fw.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 自定义字符数组作为缓冲区，建议使用。
     * @param fromPath
     * @param toPath
     */
    public static void readWriteDemo_2(String fromPath, String toPath){
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(fromPath);
            fw = new FileWriter(toPath);

            //注意和FileInputStream不同的是，这里读取的是字符，所以要新建字符数组做缓冲区。
            char[] buf = new char[1024];
            int len = 0;

            while((len = fr.read(buf)) != -1){
                fw.write(buf, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用BufferedReader和BufferedWriter，建议使用。
     * @param fromPath
     * @param toPath
     */
    public static void readWriteDemo_3(String fromPath, String toPath){
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try {
            bufr = new BufferedReader(new FileReader(fromPath));
            bufw = new BufferedWriter(new FileWriter(toPath));

            String line = null;
            while((line = bufr.readLine()) != null){
                bufw.write(line);
                bufw.newLine();
                bufw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufr != null){
                try {
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufw != null){
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
