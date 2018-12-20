package JVM.TestInitailization;

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 */
public class NotInitialization_1 {
    public static class superClass{
        static {
            System.out.println("superclass init");
        }
        public static int value = 123;
    }

    public static class subClass extends superClass{
        static {
            System.out.println("subclass init");
        }
    }

    public static void main(String[] args) {
        System.out.println(subClass.value);
    }
}
