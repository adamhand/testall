package Thread.ProducerAndCustomer_2;

/**
 * 多生产者和消费者问题:while-noifyAll
 * while+notify()可能会导致死锁
 */

class Resource
{
    private String name;
    private int count;
    private boolean flag = false;

    public synchronized void set(String name)
    {
        while(flag)//flag为1，表示还没消费完
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count++;
        System.out.println(Thread.currentThread().getName()+" 生产者...... "+this.name);
        flag = true;
        notifyAll();
    }

    public synchronized void out()
    {
        while(! flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //this.name = name + count;
        //count--;
        System.out.println(Thread.currentThread().getName()+" 消费者............... " +this.name);
        flag = false;
        notifyAll();
    }
}

class Producer implements Runnable
{
    private Resource resource;

    public Producer(Resource resource)
    {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true)
        {
            resource.set("烤鸭");
        }
    }
}

class Customer implements Runnable
{
    private Resource resource;
    public Customer(Resource resource)
    {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true)
        {
            resource.out();
        }
    }
}

public class ProducerAndCustomer {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Customer customer = new Customer(resource);

        Thread t0 = new Thread(producer);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(customer);
        Thread t3 = new Thread(customer);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
