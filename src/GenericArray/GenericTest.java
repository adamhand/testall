package GenericArray;

import javafx.util.Pair;
import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        ArrayDeque<Integer>[] stacks = (ArrayDeque<Integer>[]) Array.newInstance(ArrayDeque.class, 2);    //1
        List<String>[] lsa = (List<String>[]) Array.newInstance(ArrayList.class, 4);
        stacks[0] = new ArrayDeque<Integer>();
        stacks[1] = new ArrayDeque<Integer>();
    }
}
