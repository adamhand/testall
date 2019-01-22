package Thread.LockAndSynchronizedTest.SynchronizedTest;

import java.util.concurrent.CountDownLatch;

class Resource{
    private int count;
    private String name;
    private boolean flag = false;
    CountDownLatch begin;
    CountDownLatch end;

    public Resource(CountDownLatch begin, CountDownLatch end){
        this.begin = begin;
        this.end = end;
    }

    public void set(String name){
        synchronized (Resource.class){
            while (flag){
                try {
//                    this.wait();  //为什么并发量不高的时候这么写也对?
                    Resource.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = true;
            count++;
            this.name = name;
            System.out.println(Thread.currentThread().getName()+"生产商品.... " + name + " " + count);
            Resource.class.notifyAll();
        }
    }

    public void get(){
        synchronized (Resource.class){
            while (!flag){
                try {
//                    this.wait();
                    Resource.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = false;
            System.out.println(Thread.currentThread().getName() + "消费商品 "+ name + " " + count);
            Resource.class.notifyAll();
//            this.notifyAll();
        }
    }
}

class Producer implements Runnable{
    private Resource resource;

    public Producer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            resource.begin.await();
            resource.set("瓜子");
            resource.end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    private Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            resource.begin.await();
            resource.get();
            resource.end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TimerWatcher{
    private long startTime;
    private long endTime;

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void end(){
        endTime = System.currentTimeMillis();
    }

    public float getCostTime(){
        return (float)(endTime - startTime) / 1000;
    }
}

public class SynchronizedThread {
    public static void main(String[] args) throws InterruptedException {
        int parallel = 10000;

        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(parallel);

        TimerWatcher watcher = new TimerWatcher();
        watcher.start();

        Resource resource = new Resource(begin, end);
        Consumer consumer = new Consumer(resource);
        Producer productor = new Producer(resource);
        for (int i = 0; i < parallel; i++){
            new Thread(productor).start();
            new Thread(consumer).start();
        }

        begin.countDown();
        end.await();

        watcher.end();

        System.out.println("花费时间: "+watcher.getCostTime());
    }
}

