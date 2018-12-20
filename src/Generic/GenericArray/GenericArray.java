package Generic.GenericArray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{

}

public class GenericArray {
    public static void main(String[] args) {
//        Stack<Integer>[] stacks = new Stack[2];
//        stacks[0] = new Stack<Integer>();
//        stacks[1] = new Stack<Integer>();
//
//        stacks[0].push(Integer.valueOf(12));
//
//        System.out.println(stacks[0].pop());

//        ArrayDeque<TreeNode>[] stacks = new ArrayDeque[2];    //1
//        stacks[0] = new ArrayDeque<TreeNode>();
//        stacks[1] = new ArrayDeque<TreeNode>();

//        Stack<String>[] stacks = new Stack[2];
//        stacks[0] = new Stack<>();
//        stacks[1] = new Stack<>();
//
//        stacks[0].push(String.valueOf(12));
//        stacks[1].push("1212");
////        stacks[1].push(13);
//
//        System.out.println(stacks[0].pop());
//        System.out.println(stacks[1].pop());
//
//        List<String>[] stringLists = new ArrayList[1];

//        List<?>[] list = new ArrayList<?>[10];
//        list[0].add(12);

        List<?>[] lsa = new List<?>[10];                //1
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));

        oa[1] = li;

        Integer s = (Integer) lsa[1].get(0);

        System.out.println(s);
    }
}
