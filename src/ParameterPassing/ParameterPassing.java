package ParameterPassing;

/**
 * 参数传递的例子.结果：4
 */
public class ParameterPassing {
    int x = 3;

    public static void main(String[] args) {
        ParameterPassing p = new ParameterPassing();
        p.x = 9;
        show(p);
        System.out.println(p.x);
    }

    public static void show(ParameterPassing p){
        p.x = 4;
    }
}
