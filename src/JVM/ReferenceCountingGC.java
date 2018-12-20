package JVM;

public class ReferenceCountingGC {
    public Object instance = null;

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假如在这时候进行垃圾回收，objA和objB依然会被回收，这就说明JVM不是依靠引用计数算法来
        //判断对象是否存活的。
        System.gc();
    }
}
