package JVM.TestInitailization;

/**
 * 通过数组定义来引用类，不会触发此类的初始化
 */
public class NotInitialization_2 {
    public static class superClass{
        static {
            System.out.println("superclass init");
        }
        public static int value = 123;
    }

    public static void main(String[] args) {
        superClass[] superClasses = new superClass[10];
    }
}
