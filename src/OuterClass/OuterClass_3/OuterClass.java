package OuterClass.OuterClass_3;

/**
 *1.声明在类体部，方法体外，并且使用static修饰的内部类
 *2.访问特点可以类比静态变量和静态方法
 *3.脱离外部类的实例独立创建
 *在外部类的外部构建内部类的实例
 *new Outer.Inner();
 *在外部类的内部构建内部类的实例
 *new Inner();
 *4.静态内部类体部可以直接访问外部类中所有的静态成员，包含私有
 * 如果内部类中定义了静态函数，则该内部类也必须是静态的。
 * 如果一个类要被声明为static的，只有一种情况，就是静态内部类。如果在外部类声明为static，程序会编译都不会过。
 */
public class OuterClass {
    private static int num = 3;

    public static class InnerClass{
        public static void show(){
            System.out.println("innerClass ...."+ num);
        }
    }
}

class Main{
    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        innerClass.show();

        OuterClass.InnerClass.show();
    }
}
