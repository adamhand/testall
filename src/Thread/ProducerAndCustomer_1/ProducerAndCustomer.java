package Thread.ProducerAndCustomer_1;

/**
 * 生产者和消费者问题（一个生产者一个消费者） if-notify()
 */
class Resource
{
    private String name;
    private int count;
    private boolean flag = false;

    public synchronized void set(String name)
    {
        if(flag)//flag为1，表示还没消费完
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
        notify();
    }

    public synchronized void out()
    {
        if(! flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        this.name = name + count;
//        count--;
        System.out.println(Thread.currentThread().getName()+" 消费者............... " +this.name);
        flag = false;
        notify();
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
        Thread t1 = new Thread(customer);

        t0.start();
        t1.start();
    }
}
