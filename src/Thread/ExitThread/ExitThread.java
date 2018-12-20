package Thread.ExitThread;

/**
 * 使用标志位来退出线程
 */
class MyThread extends Thread
{
    private boolean exitFlag = false;

    @Override
    public void run() {
        while(! exitFlag)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                exitFlag = true;
                //break;
            }
            System.out.println("我还没退出 "+Thread.currentThread().getName()+" "+Thread.currentThread().getId());
        }
    }
}

public class ExitThread {
    public static void main(String[] args) {
        MyThread myThread0 = new MyThread();
        MyThread myThread1 = new MyThread();

        myThread0.start();
        myThread1.start();
        try {
            Thread.sleep(1000);    //主线程睡1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread0.interrupt();
        myThread1.interrupt();
        System.out.println("我已退出");
    }
}
