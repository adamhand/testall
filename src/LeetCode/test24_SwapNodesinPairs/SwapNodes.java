package LeetCode.test24_SwapNodesinPairs;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SwapNodes {
//    public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null)
//            return head;
//
//        ListNode nHead = new ListNode(0);
//        nHead.next = head;
//        ListNode cur = nHead;
//        while (cur.next != null && cur.next.next != null){
//            ListNode left = cur.next;
//            ListNode right = cur.next.next;
//            left.next = right.next;
//            right.next = left;
//            cur.next = right;
//            cur = cur.next.next;
//        }
//        return nHead.next;
//    }

    //递归
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
