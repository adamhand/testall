package Thread.VolatileDemo;

/**
 * 卖票案例：volatile关键字
 */
class Ticket implements Runnable
{
    private volatile int num = 100;

    @Override
    public void run() {
        while (true)
        {
            if(num > 0)
            {
                System.out.println(Thread.currentThread().getName()+"...sale...."+num--);
            }
            else
            {
                break;
            }
        }
    }
}
public class VolatileDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t0 = new Thread(ticket);
        Thread t1 = new Thread(ticket);

        t0.start();
        t1.start();
    }
}


