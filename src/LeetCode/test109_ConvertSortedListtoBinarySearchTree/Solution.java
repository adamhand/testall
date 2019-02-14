package LeetCode.test109_ConvertSortedListtoBinarySearchTree;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private ListNode head;

    private int countSize(ListNode head){
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    private TreeNode convertListToBST(int l, int r){
        if(l > r)
            return null;

        int mid = (l + r) / 2;

        //左子树
        TreeNode left = convertListToBST(l, mid - 1);
        //根
        TreeNode root = new TreeNode(head.val);
        System.out.println(head.val);
        root.left = left;

        head = head.next;
        //右子树
        root.right = convertListToBST(mid + 1, r);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = countSize(head);
        this.head = head;

        return convertListToBST(0, size - 1);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        new Solution().sortedListToBST(node1);
    }
}
