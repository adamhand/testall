package Test;

import java.util.*;


//class TreeNode {
//     int val;
//    TreeNode left = null;
//    TreeNode right = null;
//    TreeNode next = null;
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//}

class ListNode{
    int value;
    ListNode nextNode;

    ListNode(int value){
        this.value = value;
    }
}


public class Test1 {
    public static void main(String[] args) {
        char[] chars = {'a','b','c'};



    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.nextNode == null || pHead.nextNode.nextNode == null)
            return pHead;

        ListNode slow = pHead, fast = slow.nextNode;
        while (slow != null) {
            if (slow.value == fast.value) {
                while (slow.value == fast.value) {
                    fast = fast.nextNode;
                }

            }
        }
        return pHead;
    }
}
