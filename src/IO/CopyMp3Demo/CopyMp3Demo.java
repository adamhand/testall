package IO.CopyMp3Demo;

import java.io.*;

public class CopyMp3Demo {
    //D:\Prom\testAll\src\IO\CopyMp3Demo
    public static void main(String[] args) {
        String fromPath = "D:\\Prom\\testAll\\src\\IO\\CopyMp3Demo\\0.mp3";
        String toPath = "D:\\Prom\\testAll\\src\\IO\\CopyMp3Demo\\1.mp3";

//        copyMp3Demo_1(fromPath, toPath);
//        copyMp3Demo_2(fromPath, toPath);
//        copyMp3Demo_3(fromPath, toPath);
        copyMp3Demo_4(fromPath, toPath);
    }

    /**
     * 一个字节一个字节读取，效率很慢，不要用。
     * @param fromPath
     * @param toPath
     */
    public static void copyMp3Demo_1(String fromPath, String toPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(fromPath);
            fos = new FileOutputStream(toPath);

            //一个字节一个字节读取
            int ch = 0;
            while ((ch = fis.read()) != -1){
                fos.write(ch);
            }
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
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用available定义缓冲区，当文件很大的时候，缓冲区会很大，不建议使用。
     * @param fromPath
     * @param toPath
     */
    public static void copyMp3Demo_2(String fromPath, String toPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(fromPath);
            fos = new FileOutputStream(toPath);

            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            fos.write(buf);
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
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用BufferedInputStream和BufferedOutputStream缓冲区。建议使用。
     * @param fromPath
     * @param toPath
     */
    public static void copyMp3Demo_3(String fromPath, String toPath){
        BufferedInputStream bufis = null;
        BufferedOutputStream bufos = null;
        try {
            bufis = new BufferedInputStream(new FileInputStream(fromPath));
            bufos = new BufferedOutputStream(new FileOutputStream(toPath));

            int ch = 0;
            while((ch = bufis.read()) != -1){
                bufos.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufis != null){
                try {
                    bufis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufos != null){
                try {
                    bufos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用自定义的数组缓冲区，建议使用。
     * @param fromPath
     * @param toPath
     */
    public static void copyMp3Demo_4(String fromPath, String toPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(fromPath);
            fos = new FileOutputStream(toPath);

            byte[] buf = new byte[1024];
            int len = 0;
            while((len = fis.read(buf)) != -1){
                fos.write(buf, 0, len);
            }
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
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
