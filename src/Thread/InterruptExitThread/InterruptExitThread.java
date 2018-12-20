package Thread.InterruptExitThread;

/**
 * interrupt方法结束线程
 */
class MyThread extends Thread
{
    @Override
    public void run() {
        while (true)
        {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("子线程还没退出");
        }
    }
}

public class InterruptExitThread {
    public static void main(String[] args) {
        MyThread myThread0 = new MyThread();

        myThread0.start();
        //myThread0.yield();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread0.interrupt();

        System.out.println("主线程退出");
    }
}

