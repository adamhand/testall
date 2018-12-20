package JVM.TestGC;

/**
 * 动态对象年龄判定测试
 * VM args: -verbose:gc -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
 * -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 */
public class TestTenuringThreshold2 {
    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold2(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        //allocation1和allocation2和大于Survivor一半
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];

        allocation3 = new byte[_1MB * 4];
        allocation4 = new byte[_1MB * 4];
        allocation4 = null;
        allocation4 = new byte[_1MB * 4];
    }

    public static void main(String[] args) {
        testTenuringThreshold2();
    }
}
