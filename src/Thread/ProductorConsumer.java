package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProductorConsumer {
    private static BlockingQueue<String> quene = new ArrayBlockingQueue<>(5);

    private static class Productor extends Thread{
        @Override
        public void run() {
            try {
                quene.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("productor...");
        }
    }

    private static class Consumer extends Thread{
        @Override
        public void run() {
            try {
                String product = quene.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consumer...");
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 2; i++){
            Productor productor = new Productor();
            productor.start();
        }

        for(int i = 0; i < 5; i++){
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for(int i = 0; i < 3; i++){
            Productor productor = new Productor();
            productor.start();
        }
    }
}

