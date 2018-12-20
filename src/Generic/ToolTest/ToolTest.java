package Generic.ToolTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ToolTest {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(23);
//      ls.add("text");
        try {
            //getDeclaredMethods(),该方法是获取本类中的所有方法
            Method method = ls.getClass().getDeclaredMethod("add",Object.class);

            method.invoke(ls,"test");
            method.invoke(ls,42.9f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for ( Object o: ls){
            System.out.println(o);
        }
    }
}
