package JVM.TestGC;

/**
 * 长期存活的对象进入老年代测试
 * VM args: -verbose:gc -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 * -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 */
public class TestTenuringThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB * 4];
        allocation3 = new byte[_1MB * 4];
        allocation3 = null;
        allocation3 = new byte[_1MB * 4];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
