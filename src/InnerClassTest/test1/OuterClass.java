package InnerClassTest.test1;

public class OuterClass {
    //成员内部类
    private class InstanceInnerClass{}
    //静态内部类
    private class StaticInnerClass{}

    public static void main(String[] args) {
        //匿名内部类
        new Thread(){}.start();
        new Thread(){}.start();
        //方法内部类
        class MethodClass_1{}
        class MethodClass_2{}
    }
}
