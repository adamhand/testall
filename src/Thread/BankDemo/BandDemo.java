package Thread.BankDemo;

/**
 * 多线程同步：存钱问题
 */
class Bank{
    private int sum;

    public synchronized void add(int num){
        sum += num;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum= :"+sum);
    }
}

class Customer implements Runnable{
    private Bank bank = new Bank();

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            bank.add(100);
        }
    }
}

public class BandDemo {
    public static void main(String[] args) {
        Customer customer = new Customer();

        Thread t1 = new Thread(customer);
        Thread t2 = new Thread(customer);

        t1.start();
        t2.start();
    }
}
