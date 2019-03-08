package Thread.SynchronizedTest3;

public class Solution {
    public static final Solution staticClass1 = new Solution();

    public static synchronized void staticMethod1(){
        while (true){
            System.out.println("static method1 running........");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void staticMethod2(){
        while (true){
            System.out.println("static method2 running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Solution solution1 = new Solution();
        final Solution solution2 = new Solution();

        new Thread(new Runnable() {
            @Override
            public void run() {
                solution1.staticMethod1();
//                staticClass1.staticMethod2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                solution2.staticMethod2();
//                staticClass1.staticMethod1();
            }
        }).start();
    }
}
