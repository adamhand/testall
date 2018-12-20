package JVM.TestGC;

/**
 * 大对象直接进入老年代测试
 * VM args: -verbose:gc -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
 */
public class TestPerSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void testPerSizeThreshold(){
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPerSizeThreshold();
    }
}
