package Thread.PrintDemo.DemoFour;

import Thread.PrintDemo.ToolUtil.HelperTool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用atomic关键字
 */
public class MethodFour {
    private AtomicInteger value = new AtomicInteger(2);

    public Runnable newThreadOne()
    {
        final String[] inputArr = HelperTool.buildNoArr(52);
        return new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < inputArr.length; i = i + 2)
                {
                    while(value.get() == 1)
                    {

                    }
                    HelperTool.print(inputArr[i], inputArr[i + 1]);
                    value.set(1);
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
                    while(value.get() == 2)
                    {

                    }
                    HelperTool.print(inputArr[i]);
                    value.set(2);
                }
            }
        };
    }

    public static void main(String[] args) {
        MethodFour methodFour = new MethodFour();

        HelperTool.instance.run(methodFour.newThreadOne());
        HelperTool.instance.run(methodFour.newThreadTwo());

        HelperTool.instance.shutDown();
    }
}
