package Thread.ExtendThreadClass;

/**
 * 通过继承Thread的方法创建线程
 */
class MyThread extends Thread
{
    @Override
    public void run() {
        System.out.println("创建的线程："+ Thread.currentThread().getName()+" "+Thread.currentThread().getId());
    }
}

public class ExtendThreadClass {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();  //创建的线程：Thread-0 11
        myThread.run();    //创建的线程：main 1
    }
}
