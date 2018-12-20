package JVM.TestGC;

/**
 * 空间分配担保测试
 * VM args: -verbose:gc -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
 * -XX:+UseSerialGC
 */
public class TestHandlePromotion {
    private static final int _1MB = 1024 * 1024;

    public static void testHandlePromotion(){
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        //allocation1和allocation2和大于Survivor一半
        allocation1 = new byte[_1MB * 2];
        allocation2 = new byte[_1MB * 2];
        allocation3 = new byte[_1MB * 2];

        allocation1 = null;
        allocation4 = new byte[_1MB * 2];
        allocation5 = new byte[_1MB * 2];
        allocation6 = new byte[_1MB * 2];

        allocation4 = null;
        allocation5 = null;
        allocation6 = null;

        allocation7 = new byte[_1MB * 2];
    }

    public static void main(String[] args) {
        testHandlePromotion();
    }
}
