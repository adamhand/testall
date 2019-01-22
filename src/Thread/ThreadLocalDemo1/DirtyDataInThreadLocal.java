package Thread.ThreadLocalDemo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DirtyDataInThreadLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //使用固定大小为1的线程池，说明上一个线程属性会被下一个线程属性复用
        ExecutorService pool = Executors.newFixedThreadPool(1);

        for(int i = 0; i < 2; i++){
            MyThread thread = new MyThread();
            pool.execute(thread);
        }
    }

    private static class MyThread extends Thread{
        private static boolean flag = true;

        @Override
        public void run() {
            if(flag){
                //第一个线程set后，没有remove，第二个线程也没有进行set操作
                threadLocal.set(this.getName() + ", session info.");
                flag = false;
            }
            System.out.println(this.getName() + " 线程是 " + threadLocal.get());
        }
    }
}
