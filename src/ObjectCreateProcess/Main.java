package ObjectCreateProcess;

/**
 * 一个对象初始化的过程：
 * 1.JVM会读取指定路径下的字节码文件，并加载进内存。如果有直接父类时，会先加载父类的字节码文件。
 * 2.在对内存中开辟一段空间，分配地址。
 * 3.为子类对象的属性进行默认初始化，
 * 4.调用对象的构造函数进行构造器初始化。
 * 5.如果有父类，先调用父类的构造器对父类进行初始化。
 * 6.父类初始化完毕之后，对子类对象的属性进行显式初始化。
 * 7.子类构造函数的特定初始化（子类构造函数后面的语句）。
 * 8.初始化完毕，将地址赋值给引用变量。
 */
public class Main {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.show();
    }
}
