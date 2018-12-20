package Generic.GenTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型类
 * @param <T>
 */
public class GenericTest<T> {
    private T value;

    public T getObject(){
        return value;
    }

    /**
     * 泛型方法，将泛型定义现在返回值之前。
     * @param w
     * @param <W>
     */
    public <W> void method(W w){
        System.out.println("method:" + w);
    }

    /**
     * 当方法静态时，不能访问类上定义的泛型。如果静态方法使用泛型，
     * 只能将泛型定义在方法上。
     * @param y
     * @param <Y>
     */
    public static <Y> void staticMethod(Y y){
        System.out.println("staticmethod" + y);
    }

    public static <M extends Comparable<M>> int countGreaterThan(M[] array, M elem){
        int count = 0;
        for(M e : array){
            if(e.compareTo(elem) > 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        Integer[] array = {1,2,3,4,5,6,7,8,9};
////        GenericTest.countGreaterThan(array, 3);
//        List<?> list = null;
//        list = new ArrayList<Integer>();
////        list = new ArrayList<Long>();
//
//        list.get(new Integer(2));

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        System.out.println(l1.getClass() == l2.getClass());
    }
}
