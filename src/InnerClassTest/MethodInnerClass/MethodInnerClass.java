package InnerClassTest.MethodInnerClass;

public class MethodInnerClass {
    public static void main(String[] args)  {
        test(3);
    }

    public static void test(final int b) {
        final int a = 10;
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b);
            }
        }.start();
    }
}
