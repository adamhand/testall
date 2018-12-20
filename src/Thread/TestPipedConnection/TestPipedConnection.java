package Thread.TestPipedConnection;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 通道方式实现线程同步
 */
class Producer implements Runnable
{
    private PipedOutputStream pos;

    public Producer(PipedOutputStream pos)
    {
        this.pos = pos;
    }

    @Override
    public void run() {
        int i = 0;
        while(true)
        {
            try {
                 Thread.sleep(100);
                 pos.write(i++);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

class Customer implements Runnable
{
    private PipedInputStream pis;
    public Customer(PipedInputStream pis)
    {
        this.pis = pis;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                System.out.println("customer "+pis.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ;
        }
    }
}

public class TestPipedConnection {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();;
        PipedInputStream pis = new PipedInputStream();

        try {
            pos.connect(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Producer producer = new Producer(pos);
        Customer customer = new Customer(pis);

        Thread t0 = new Thread(producer);
        Thread t1 = new Thread(customer);

        t0.start();
        t1.start();
    }
}

