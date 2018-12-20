package Thread.TicketDemo;

/**
 * 卖票案例：同步代码块
 */
class Ticket implements Runnable
{
    private int num = 100;

    @Override
    public void run() {
        while (true)
        {
            synchronized (this)
            {
                if(num > 0)
                {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"...sale...."+num--);
                }
                else
                {
                    break;
                }
            }
        }
    }
}

public class TicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t0 = new Thread(ticket);
        Thread t1 = new Thread(ticket);

        t0.start();
        t1.start();
    }
}
