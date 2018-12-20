package Thread.ThreadLocalDemo;

/**
 * 用ThreadLocal类实现同步，没有办法实现同步，因为两个线程操作的是两个num的副本
 */
class Ticket implements Runnable
{
    private static ThreadLocal<Integer> num = new ThreadLocal<Integer>()
    {
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    @Override
    public void run() {
        while (true)
        {
            if(num.get() > 0)   //注意这里
            {
                System.out.println(Thread.currentThread().getName()+"...sale...."+(num.get()));
                num.set(num.get() - 1);
            }
            else
            {
                break;
            }
        }
    }
}
public class ThreadLocalDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t0 = new Thread(ticket);
        Thread t1 = new Thread(ticket);

        t0.start();
        t1.start();
    }
}
