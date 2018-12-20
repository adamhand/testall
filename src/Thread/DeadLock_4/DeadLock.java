package Thread.DeadLock_4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁解决方法之一：申请锁的时候加上等待时间.
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
                    if(lockb.tryLock(100, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getName()+" if lockb......");
                        }
                        finally {
                            lockb.unlock();
                        }
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
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
                    if(locka.tryLock(100, TimeUnit.MILLISECONDS)) {
                       try {
                           System.out.println(Thread.currentThread().getName() + " if lockb......");
                       }
                       finally {
                           locka.unlock();
                       }
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
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
