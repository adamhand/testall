package Thread.JoinMethod;

/**
 * join方法
 */
class MyThread extends Thread
{
    @Override
    public void run() {
        for(int i = 0; i < 50; i++) {
            System.out.println("当前线程名字和ID： " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        }
    }
}

public class JoinMethod {
    public static void main(String[] args) {
        MyThread myThread0 = new MyThread();
        MyThread myThread1 = new MyThread();

        myThread0.start();
        try {
            myThread0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread1.start();

        for(int i = 0; i < 50; i++)
        {
            System.out.println("当前线程名字和ID： "+Thread.currentThread().getName()+" "+Thread.currentThread().getId());
        }
    }
}
