package LeetCode.test104_MaxDeepthOfBiTree;

import javafx.util.Pair;
import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class DeepthOfBiTree {

    //递归解法
//    public int maxDepth(TreeNode root) {
//        if(root == null)
//            return 0;
//
//        int leftDeepth = maxDepth(root.left);
//        int rightDeeth = maxDepth(root.right);
//
//        return leftDeepth > rightDeeth ? leftDeepth + 1 : rightDeeth + 1;
//    }


    public int maxDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();

        if(root != null)
            stack.add(new Pair<>(root, 1));

        int deep = 0;
        while(!stack.isEmpty()){
            //Pair中只能存储一个键值对；Map中可以存储多个键值对。
            Pair<TreeNode, Integer> cur = stack.pollLast();
            TreeNode curNode = cur.getKey();
            int curDeep = cur.getValue();

            if(curNode != null){
                deep = deep > curDeep ? deep : curDeep;
                stack.add(new Pair<>(curNode.left, curDeep + 1));
                stack.add(new Pair<>(curNode.right, curDeep + 1));
            }
        }

        return deep;
    }
}
