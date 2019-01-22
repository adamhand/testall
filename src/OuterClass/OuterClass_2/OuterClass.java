package OuterClass.OuterClass_2;

/**
 * 1.定义在方法体，甚至比方法体更小的代码块中
 *2.类比局部变量。
 *3.局部内部类是所有内部类中最少使用的一种形式。
 *4.局部内部类可以访问的外部类的成员根据所在方法体不同。
 *如果在静态方法中：
 *可以访问外部类中所有静态成员，包含私有
 *如果在实例方法中：
 *可以访问外部类中所有的成员，包含私有。
 *局部内部类可以访问所在方法中定义的局部变量，但是要求局部变量必须使用final修饰。
 */
public class OuterClass {
    public void method(){
        final int i = 1;    //不加final好像也可以

        class InnerClass{   //不允许有public等修饰符
            public void show(){
                System.out.println("innerClass show...."+ i);
            }
        }

        new InnerClass().show();
    }
}

class Main{
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.method();

    }
}
