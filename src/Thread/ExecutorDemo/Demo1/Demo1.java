package Thread.ExecutorDemo.Demo1;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.concurrent.*;

class MyCallable implements Callable{
    @Override
    public Object call() {
        Long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Long stopTime = System.currentTimeMillis();

        Long gapTime = stopTime - startTime;
        return gapTime.toString();
    }
}


public class Demo1 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        Future f = es.submit(new MyCallable());
        try {
            System.out.println(f.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            es.shutdown();
        }
    }
}
