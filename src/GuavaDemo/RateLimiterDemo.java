package GuavaDemo;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterDemo {
    private CountDownLatch begin = new CountDownLatch(1);
    private CountDownLatch end = new CountDownLatch(30);

    private void test() throws InterruptedException {
        RateLimiter limiter = RateLimiter.create(0.5);

        List<Runnable> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(new UserRequire(i, begin, end));
        }

        ExecutorService pool = Executors.newCachedThreadPool();
        for(Runnable runnable : list){
            System.out.println("等待时间: "+limiter.acquire());
            pool.submit(runnable);
        }

        begin.countDown();
        end.await();
    }

    public static void main(String[] args) throws InterruptedException {
        new RateLimiterDemo().test();
    }
}

class UserRequire implements Runnable{
    private CountDownLatch begin;
    private CountDownLatch end;
    private int id;

    public UserRequire(int id, CountDownLatch begin, CountDownLatch end){
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            begin.await();
            System.out.println(id);
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}