package Thread.PrintDemo.ToolUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个公用的方法，用来进行数字、字母和ASCII表的转换.
 */
public enum HelperTool {
    instance,
    haha;

    private static final ExecutorService tPool = Executors.newFixedThreadPool(2);

    /**
     * 将整数变为字符串存储在字符串数组中。
     * @param max
     * @return
     */
    public static String[] buildNoArr(int max)
    {
        String[] noArr = new String[max];
        for (int i = 0; i < noArr.length; i++) {
            noArr[i] = Integer.toString(i + 1);
        }

        return noArr;
    }

    /**
     * 将大写字母转换成字符串存储在字符串数组中
     * @param max
     * @return
     */
    public static String[] buildCharArr(int max)
    {
        String[] charArr = new String[max];
        int temp = 65;
        for(int i = 0; i < max; i++)
        {
            charArr[i] = String.valueOf((char)(temp + i));
        }

        return charArr;
    }

    public static void print(String... input)
    {
        if(input == null)
        {
            return;
        }
        else
        {
            for(String each : input)
            {
                System.out.println(each);
            }
        }
    }

    public void run(Runnable r)
    {
        tPool.submit(r);
    }

    public void shutDown()
    {
        tPool.shutdown();
    }
}
