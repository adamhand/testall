package Thread.EmployerTest;

/**
 * 员工类
 */
public class Employer implements Runnable {
    private static int count = 100;
    private static int front = 0;
    private static int back = 0;

    public static int getCount() {
        return count;
    }

    public static int getFront() {
        return front;
    }

    public static int getBack() {
        return back;
    }

    @Override
    public void run() {
        while(count > 0)
        {
            synchronized (this)
            {
                if("前门".equals(Thread.currentThread().getName()))
                {
                    front++;
                }
                else if("后门".equals(Thread.currentThread().getName()))
                {
                    back++;
                }
                else{}

                System.out.println("第"+count--+"号员工，从"+Thread.currentThread().getName()+"出，取出的双色球号码为: "+Lottery.getResult());

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
