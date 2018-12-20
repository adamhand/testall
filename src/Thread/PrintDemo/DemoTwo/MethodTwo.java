package Thread.PrintDemo.DemoTwo;

import Thread.PrintDemo.ToolUtil.HelperTool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用Lock方法实现。
 */
public class MethodTwo {
    private final ThreadToGo threadToGo = new ThreadToGo(); //final修饰一个对象，那么这个对象的引用不能变，但是值是不可以变的。
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public Runnable newThreadOne()
    {
        return new Runnable()
        {
            private String[] inputArr = HelperTool.buildNoArr(52);

            @Override
            public void run() {
                for(int i = 0; i < inputArr.length; i = i + 2)
                {
                    try {
                        lock.lock();
                        while(threadToGo.value == 2)
                        {
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        HelperTool.print(inputArr[i], inputArr[i + 1]);
                        threadToGo.value = 2;
                        condition.signal();
                    }
                    finally {
                        lock.unlock();
                    }
                }
            }
        };
    }

    public Runnable newThreadTwo()
    {
        return new Runnable() {
            private String[] inputArr = HelperTool.buildCharArr(26);

            @Override
            public void run() {
                for(int i = 0; i < inputArr.length; i++)
                {
                    try {
                        lock.lock();
                        while(threadToGo.value == 1)
                        {
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        HelperTool.print(inputArr[i]);
                        threadToGo.value = 1;
                        condition.signal();
                    }
                    finally {
                        lock.unlock();
                    }
                }
            }
        };
    }

    class ThreadToGo
    {
        int value = 1;
    }

    public static void main(String[] args) {
        MethodTwo methodTwo = new MethodTwo();

        HelperTool.instance.run(methodTwo.newThreadOne());
        HelperTool.instance.run(methodTwo.newThreadTwo());

        HelperTool.instance.shutDown();
    }
}
