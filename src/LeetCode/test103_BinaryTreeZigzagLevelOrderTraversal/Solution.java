package LeetCode.test103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                list.add(node.val);
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            }
            if (!list.isEmpty()){
                result.add(list);
                list = new ArrayList<>();
            }

            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                list.add(node.val);

                if (node.right != null)
                    stack1.push(node.right);
                if (node.left != null)
                    stack1.push(node.left);
            }
            if (!list.isEmpty()){
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }
}
