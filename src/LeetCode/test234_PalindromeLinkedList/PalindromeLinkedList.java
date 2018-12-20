package LeetCode.test234_PalindromeLinkedList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class PalindromeLinkedList {
    //翻转整条链表
//    public static boolean isPalindrome(ListNode head) {
//        if(head == null || head.next == null)
//            return true;
//
//        ListNode nHead = reverse(head);
//        ListNode p1 = head, p2 = nHead;
//        while (p1 != null){
//            if(p1.val != p2.val)
//                return false;
//
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//
//        return true;
//    }
//
//    //注意，不能就地翻转，得新建节点，要不然原链表会被破坏
//    private static ListNode reverse(ListNode head){
//        ListNode nHead = new ListNode(0);
//        ListNode temp = head;
//        while (temp != null){
//            ListNode node = new ListNode(temp.val);
//            ListNode next = temp.next;
//            node.next = nHead.next;
//            nHead.next = node;
//            temp = next;
//        }
//
//        return nHead.next;
//    }

    //翻转链表的时间复杂度比较高，可以将链表分成两个子链表，翻转其中一个，再将两个子链表比较
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //链表个数为奇数
        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null){
            if(fast.val != slow.val)
                return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    //就地翻转即可
    private static ListNode reverse(ListNode head){
        ListNode nHead = new ListNode(0);
        ListNode temp = head;
        while (temp != null){
            ListNode next = temp.next;
            temp.next = nHead.next;
            nHead.next = temp;
            temp = next;
        }

        return nHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        new PalindromeLinkedList().isPalindrome(node1);
//        ListNode node = node1;
//        for (int i = 0; i < 4; i++){
//            System.out.print(node.val+" ");
//            node = node.next;
//        }
//
//        ListNode nHead = reverse(node1);
//
//        System.out.println();
//        for (int i = 0; i < 4; i++){
//            System.out.print(nHead.val+" ");
//            nHead = nHead.next;
//        }
    }
}
