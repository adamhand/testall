package Thread.IsAliveTest;

/**
 * 测试isAlive函数
 */
class MyThread extends Thread
{
    @Override
    public void run() {
        System.out.println("run= "+this.isAlive());
    }
}

public class IsAliveTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin: "+myThread.isAlive());
        myThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end: "+myThread.isAlive());
    }
}
