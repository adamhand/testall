package Thread.CountdownLantchDemo.SemaphoreDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        int workerNum = 10;
        final Semaphore semaphore = new Semaphore(5);

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < workerNum; i++){
            final int j = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("工人"+j+"正在使用机器");
                        Thread.sleep(1000);
                        System.out.println("工人"+j+"释放机器");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
