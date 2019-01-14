package Thread.CountdownLantchDemo;

import java.util.concurrent.CountDownLatch;


class Main{
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDown = new CountDownLatch(1);
        CountDownLatch await = new CountDownLatch(5);

        // 依次创建并启动处于等待状态的5个MyRunnable线程
        for (int i = 0; i < 5; ++i) {
            new Thread(new MyRunnable(countDown, await, i)).start();
        }

        System.out.println("用于触发处于等待状态的线程开始工作......");
        System.out.println("用于触发处于等待状态的线程工作完成，等待状态线程开始工作......");
        countDown.countDown();
        await.await();
        System.out.println("Bingo!");
        }
}

public class MyRunnable implements Runnable {

    private final CountDownLatch countDown;
    private final CountDownLatch await;
    private int index;

    public MyRunnable(CountDownLatch countDown, CountDownLatch await, int index) {
        this.countDown = countDown;
        this.await = await;
        this.index = index;
    }

    public void run() {
        try {
            countDown.await();//等待主线程执行完毕，获得开始执行信号...
            System.out.println("处于等待的线程开始自己预期工作......  "+index);
            await.countDown();//完成预期工作，发出完成信号...
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

