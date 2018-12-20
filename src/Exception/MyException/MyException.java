package Exception.MyException;

public class MyException {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Demo d = new Demo();
        d.method(arr, -1);
    }
}

/**
 * 继承自Exception，如果在Demo中的method方法里抛出这个异常，那么必须在Demo的method方法上声明
 * 或在method方法中捕捉；如果采用声明的解决办法，那么所有调用method的方法都需要声明
 */
class FuShuIndexException1 extends Exception{
    FuShuIndexException1(){

    }

    FuShuIndexException1(String msg){
        super(msg);
    }
}

/**
 * 继承自RuntimeException，如果在Demo中抛出这个异常，那么既不需要声明也不需要捕捉
 */
class FuShuIndexException2 extends RuntimeException{
    FuShuIndexException2(){

    }

    FuShuIndexException2(String msg){
        super(msg);
    }
}

class Demo{
    public int method(int[] arr, int index){
        if(arr ==null)
            throw new NullPointerException("数组引用不能为空");
        if(index > arr.length)
            throw new ArrayIndexOutOfBoundsException("数组指针越界");
        if(index < 0)
            throw new FuShuIndexException2("角标为如数==负数");

        return arr[index];
    }
}
