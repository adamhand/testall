package Thread.LockAndSynchronizedTest.LockTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource{
    private boolean flag = false;  //flag=true表示还没消费完
    private int count = 0;
    private String name;
    CountDownLatch begin;
    CountDownLatch end;
    Lock lock = new ReentrantLock();
    Condition producerCondition = lock.newCondition();
    Condition consumerCondition = lock.newCondition();

    public Resource(CountDownLatch begin, CountDownLatch end){
        this.begin = begin;
        this.end = end;
    }

    public void set(String name){
        try {
            lock.lock();
            while (flag){
                producerCondition.await();
            }
            count++;
            this.name = name;
            flag = true;
            System.out.println(Thread.currentThread().getName()+"生产商品 "+ name + " "+ count);
            consumerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while (!flag){
                consumerCondition.await();
            }
            flag = false;
            System.out.println(Thread.currentThread().getName()+"消费商品....... "+ name + " " + count);
            producerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Productor implements Runnable{
    private Resource resource;

    public Productor(Resource resource){
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
        } catch (Exception e) {
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

public class LockThread {
    public static void main(String[] args) throws InterruptedException {
        int parallel = 10000;

        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(parallel);

        TimerWatcher watcher = new TimerWatcher();
        watcher.start();

        Resource resource = new Resource(begin, end);
        Consumer consumer = new Consumer(resource);
        Productor productor = new Productor(resource);
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
