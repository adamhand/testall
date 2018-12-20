package NewAObject;

class Parent{
    int num = 100;
    static int staticNum = 101;

    static {
        System.out.println("Parent静态代码块：staticNum="+staticNum);
        staticNum++;
    }

    {
        System.out.println("Parent普通代码块：num="+num+" "+"staticNum="+staticNum);
        num++;
        staticNum++;
    }

    Parent(){
        super();
        System.out.println("Parent构造函数：num="+num+" "+"staticNum="+staticNum);
        num++;
        staticNum++;
        show();
        return;
    }
    void show(){
        System.out.println("Parent show函数：num="+num+" "+"staticNum="+staticNum);
    }
}

class Child extends Parent {
    int num = 1;
    static int staticNum = 2;

    static {
        System.out.println("Child静态代码块：staticNum="+staticNum);
        staticNum++;
    }

    {
        System.out.println("Child普通代码块：num+"+num+" "+"staticNum="+staticNum);
        num++;
        staticNum++;
    }

    Child(){
        super();
        //通过super初始化父类内容时，子类的成员并未显式初始化，而是父类初始化完毕时候才会进行显示初始化。
        System.out.println("Child构造函数：num="+num+" "+"staticNum="+staticNum);
        num++;
        staticNum++;
        return;
    }
    void show(){
        System.out.println("Child show函数：num="+ num+" "+"staticNum="+staticNum);
    }
}

public class NewAObject{
    public static void main(String[] args) {
        Child child = new Child();
        child.show();
    }
}
