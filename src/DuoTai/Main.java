package DuoTai;

/**
 * 多态时成员的特点：
 * 1.成员变量：编译时，如果引用变量所属的类中是否有该成员变量，有则编译通过，否则编译失败
 *           运行时，参考引用变零所属的类中的成员变量，并运行之
 *           编译运行都看左边
 * 2.成员函数（非静态）：编译时，参考引用变量所属的类中是否有该函数，有则通过否则失败
 *                    运行时，参考对象所属的类中是否有该函数
 *                    编译看左边，运行看右边。
 *3.成员函数（静态）：编译运行都看左边
 */
public class Main {
    public static void main(String[] args) {
        SuperClass.method();
        SubClass.method();

        SuperClass sc = new SubClass();
        sc.show();
        sc.method();
        System.out.println(sc.num);
    }
}
