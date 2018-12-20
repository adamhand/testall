package JVM.TestInitailization;

/**
 * 使用常量不会触发定义此常量的类的初始化
 */
public class NotInitialization_3 {
    public static class constClass{
        static{
            System.out.println("const class init");
        }

        public static final String HELLOWORLD = "hello world";
    }

    public static void main(String[] args) {
        System.out.println(constClass.HELLOWORLD);
    }
}
