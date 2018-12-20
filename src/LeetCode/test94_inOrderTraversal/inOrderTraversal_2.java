package LeetCode.test94_inOrderTraversal;

import java.util.ArrayList;
import java.util.List;


//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class inOrderTraversal_2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        inorderTravesal(root, list);

        return list;
    }

    private void inorderTravesal(TreeNode root, List<Integer> list){
        if(root != null){
            if(root.left != null)
                inorderTravesal(root.left, list);

            list.add(root.val);

            if(root.right != null)
                inorderTravesal(root.right, list);
        }
    }
}
