package JVM.TestGC;

/**
 * 对象优先在 Eden 分配测试
 * VM args: -verbose:gc -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];   //出现一次Minor GC
    }

    public static void main(String[] args) throws InterruptedException {
        testAllocation();
    }
}
