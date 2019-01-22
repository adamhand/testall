package Thread.PrintDemo.DemoThree;

import Thread.PrintDemo.ToolUtil.HelperTool;

/**
 * 利用volatile实现
 */
public class MethodThree {
    private volatile ThreadToGo threadToGo = new ThreadToGo();

    public Runnable newThreadOne()
    {
        final String[] inputArr = HelperTool.buildNoArr(52);
        return new Runnable()
        {
            @Override
            public void run() {
                for(int i = 0; i < inputArr.length; i = i + 2)
                {
                    while(threadToGo.value == 1)
                    {

                    }
                    HelperTool.print(inputArr[i], inputArr[i + 1]);
                    threadToGo.value = 1;
                }
            }
        };
    }

    public Runnable newThreadTwo()
    {
        final String[] inputArr = HelperTool.buildCharArr(26);
        return new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < inputArr.length; i++)
                {
                    while(threadToGo.value == 2)
                    {

                    }
                    HelperTool.print(inputArr[i]);
                    threadToGo.value = 2;
                }
            }
        };
    }

    class ThreadToGo
    {
        int value = 2;
    }

    public static void main(String[] args) {
        MethodThree methodThree = new MethodThree();

        HelperTool.instance.run(methodThree.newThreadOne());
        HelperTool.instance.run(methodThree.newThreadTwo());

        HelperTool.instance.shutDown();
    }
}
