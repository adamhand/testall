package LeetCode.test105_ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return core(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode core(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        if(inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);
        int rootIndex = map.get(pre[preStart]);
        int leftLen = rootIndex - inStart;
        root.left = core(pre, in, preStart + 1, preStart + leftLen, inStart, rootIndex - 1);
        root.right = core(pre, in, preStart + leftLen + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }
}
