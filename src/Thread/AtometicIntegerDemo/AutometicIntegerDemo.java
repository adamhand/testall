package Thread.AtometicIntegerDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 卖票案例：AtomicInteger
 */
class Ticket implements Runnable
{
    private AtomicInteger num = new AtomicInteger(100);

    @Override
    public void run() {
        while (true)
        {
            if(num.get() > 0)
            {
                System.out.println(Thread.currentThread().getName()+"...sale...."+num.getAndDecrement());//注意这里
            }
            else
            {
                break;
            }
        }
    }
}
public class AutometicIntegerDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t0 = new Thread(ticket);
        Thread t1 = new Thread(ticket);

        t0.start();
        t1.start();
    }
}
