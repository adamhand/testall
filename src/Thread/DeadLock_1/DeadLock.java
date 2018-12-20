package Thread.DeadLock_1;


/**
 * 死锁:同步的嵌套
 */
class Ticket implements  Runnable{
    private int num;
    Object obj = new Object();
    boolean flag = true;

    @Override
    public void run() {
        if(flag){
            while(true){
                synchronized (obj){
                    show();
                }
            }
        }
        else {
            while(true){
                this.show();
            }
        }
    }

    public  synchronized void show(){
        synchronized (obj){
            if(num > 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"sale...."+num--);
            }
        }
    }
}

public class DeadLock {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        t2.start();
    }
}
