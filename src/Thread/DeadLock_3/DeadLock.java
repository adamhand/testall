package Thread.DeadLock_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁：同步的嵌套
 */
class Test implements Runnable
{
    private boolean flag;
    Lock locka = new ReentrantLock();
    Lock lockb = new ReentrantLock();

    Test(boolean flag)
    {
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag)
        {
            while(true)
            {
                try {
                    locka.lock();
                    System.out.println(Thread.currentThread().getName()+" if locka.....");
                    try {
                        lockb.lock();
                        System.out.println(Thread.currentThread().getName()+" if lockb......");
                    }
                    finally {
                        lockb.unlock();
                    }
                }
                finally {
                    locka.unlock();
                }
            }
        }
        else
        {
            while(true)
            {
                try {
                    lockb.lock();
                    System.out.println(Thread.currentThread().getName()+" if locka.....");
                    try {
                        locka.lock();
                        System.out.println(Thread.currentThread().getName()+" if lockb......");
                    }
                    finally {
                        locka.unlock();
                    }
                }
                finally {
                    lockb.unlock();
                }
            }
        }
    }
}

class MyLock{
    public static final Object locka = new Object();
    public static final Object lockb = new Object();
}

public class DeadLock {
    public static void main(String[] args) {
        Test a = new Test(true);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.setFlag(false);
        t2.start();
    }
}
