package OuterClass.OuterClass_1;

/**
 * 普通内部类。内部类可以访问外部类的成员，但是外部类想访问内部类的成员必须建立内部类的对象。
 */
public class OuterClass {
    private int i = 1;

    class InnerClass{
        public void show(){
            System.out.println("InnerClass ...." + i);
        }
    }

    public void method(){
        InnerClass innerClass = new InnerClass();
        innerClass.show();
    }
}

class Main
{
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.method();

        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.show();
    }
}
