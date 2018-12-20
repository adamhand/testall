package Thread.ImplementCallableInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 *实现callable接口创建线程
 */
class MyCallable implements Callable<Object>
{
    private String taskNum;

    MyCallable(String taskName)
    {
        this.taskNum = taskName;
    }

    @Override
    public Object call() {
        System.out.println(">>>"+taskNum+"任务启动");
        Date dateTmp1 = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>"+taskNum + "任务终止");

        return taskNum + "任务返回运行结果，当前任务时间["+time+"毫秒]";
    }
}

public class ImplCallableInter {
    public static void main(String[] args) {
        System.out.println("程序开始运行..........");
        Date date1 = new Date();

        int taskSize = 5;   //线程池中可以容纳的线程数量
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);  //创建一个线程池
        List<Future> list = new ArrayList<Future>(); //创建有多个返回值的任务

        for(int i = 0; i < taskSize; i++)
        {
            Callable c = new MyCallable(i + " ");
            Future f = pool.submit(c);  //执行任务并获取Future对象
            list.add(f);
        }
        pool.shutdown(); //关闭线程池

        /**
         * 获取所有并发任务的运行结果
         */
        for(Future f : list)
        {
            try {
                System.out.println(">>>"+f.get().toString()); //从future对象上获取任务的返回值，并输出到控制台
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        Date date2 = new Date();
        System.out.println("程序运行结束.......，程序运行时间["+(date2.getTime() - date1.getTime())+"毫秒]");
    }
}
