package Thread.EmployerTest;

import java.util.Arrays;
import java.util.Random;

/**
 * 产生双色球号码
 */
public class Lottery {
    private static String[] redpool = {"01", "02", "03", "04", "05", "06", "07", "08", "09", //
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",//
            "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33"};

    private static String[] bluepool = {"01", "02", "03", "04", "05", "06", "07",//
            "08", "09", "10", "11", "12", "13", "14", "15", "16"};

    public  static String [] resultball=null;
    public Lottery() {
        // 红球 1-33取出6个
        // 兰球1-16 取一个
        // 随机生成一组双色球号码：
        // String[] redpool ={"01","02","03"};
        //getball(redpool, bluepool);
    }

    public static String[] getball(String[] red, String[] blue) {
        Random x = new Random();
        resultball=new String[7];
        String[] strred = new String[6];// 存储红色
        String strblue = "";// 存储蓝色
        int index = 0;// 游标
        for (int i = 0; i < strred.length; i++) {
            index = x.nextInt(33);//set random seeds
            strred[i] = red[index];//
        }
        int index2 = x.nextInt(16);
        strblue = blue[index2];

        System.arraycopy(strred,0,resultball,0,6);
        resultball[resultball.length-1]=strblue;

        return resultball;
    }

    public static String getResult(){

        return Arrays.toString(getball(redpool, bluepool));
    }
}
