package Thread.DeadLock_2;

/**
 * 死锁：同步的嵌套
 */
class Test implements Runnable
{
    private boolean flag;

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
                synchronized (MyLock.locka)
                {
                    System.out.println(Thread.currentThread().getName()+" if locka.....");
                    synchronized (MyLock.lockb)
                    {
                        System.out.println(Thread.currentThread().getName()+" if lockb......");
                    }
                }
            }
        }
        else
        {
            while(true)
            {
                synchronized (MyLock.lockb)
                {
                    System.out.println(Thread.currentThread().getName()+" else lockb...");
                    synchronized (MyLock.locka)
                    {
                        System.out.println(Thread.currentThread().getName()+" else locka...");
                    }
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
//        Test a = new Test(true);
//        Test b = new Test(false);
//
//        Thread t1 = new Thread(a);
//        Thread t2 = new Thread(b);
//
//        t1.start();
//        t2.start();

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
