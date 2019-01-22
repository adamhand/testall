package Thread.CountdownLantchDemo.LOLDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchGame {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(3);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println("所有玩家都准备好，可以开始游戏了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("玩家1已经准备好");
                latch.countDown();
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("玩家2已经准备好");
                latch.countDown();
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("玩家3已经准备好");
                latch.countDown();
            }
        });
    }
}
