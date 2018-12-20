package Thread.ImplementRunnableInterface;

/**
 * 实现Runnable接口创建线程
 */
class MyThread implements Runnable
{
    @Override
    public void run() {
        System.out.println("创建的线程: "+Thread.currentThread().getName()+" "+Thread.currentThread().getId());
    }
}

public class ImplRunnableInter {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread t0 = new Thread(myThread);

        t0.start();
    }
}
