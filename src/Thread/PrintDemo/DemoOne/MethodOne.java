package Thread.PrintDemo.DemoOne;

import Thread.PrintDemo.ToolUtil.HelperTool;

/**
 * synchronized方法
 */
public class MethodOne {
    private final threadToGo threadToGo = new threadToGo();

    public Runnable newThreadOne()
    {
        final String[] inputArr = HelperTool.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;
            @Override
            public void run() {
                for(int i = 0; i < arr.length; i = i + 2)
                {
                    synchronized (threadToGo)
                    {
                        while (threadToGo.value == 2)
                        {
                            try {
                                threadToGo.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        HelperTool.print(arr[i], arr[i + 1]);
                        threadToGo.value = 2;
                        threadToGo.notify();
                    }
                }
            }
        };
    }

    public Runnable newThreadTwo()
    {
        final String[] inputArr = HelperTool.buildCharArr(26);
        return new Runnable() {
            private String[] arr = inputArr;
            @Override
            public void run() {
                for(int i = 0; i < arr.length; i++)
                {
                    synchronized (threadToGo)
                    {
                        while(threadToGo.value == 1)
                        {
                            try {
                                threadToGo.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        HelperTool.print(arr[i]);
                        threadToGo.value = 1;
                        threadToGo.notify();
                    }
                }
            }
        };
    }

    class threadToGo
    {
        int value = 1;
    }

    public static void main(String[] args) {
        MethodOne one = new MethodOne();

        HelperTool.instance.run(one.newThreadOne());
        HelperTool.instance.run(one.newThreadTwo());
        HelperTool.instance.shutDown();
    }
}
