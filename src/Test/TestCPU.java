package Test;

//测试CPU占用率
public class TestCPU {
    public static void main(String[] args) {
//        for(; ;){
//            for(int i = 0; i < 9600000; i++);
//
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        int busyTime = 10;
        int idleTime = busyTime;
        long startTime = 0;
        while (true) {
            startTime = System.currentTimeMillis();
            // busy loop
            while ((System.currentTimeMillis() - startTime) <= busyTime);
            // idle loop
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
