package LeetCode.test203_RemoveLinkedListElements;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveLinkedList {
    //双指针
//    public ListNode removeElements(ListNode head, int val) {
//        if(head == null)
//            return head;
//        if(head.next == null && head.val == val)
//            return null;
//
//        ListNode fast = head.next, slow = head;
//        while (fast != null){
//            if(fast.val == val){
//                fast = fast.next;
//                slow.next = slow.next.next;
//            }else {
//                fast = fast.next;
//                slow = slow.next;
//            }
//        }
//        return head.val == val ? head.next : head;
//    }

    //单指针
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode p = head;
        while (p.next != null){
            if(p.next.val == val)
                p.next = p.next.next;
            else
                p = p.next;
        }

        return head.val == val ? head.next : head;
    }

    //递归
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null)
//            return null;
//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
//    }
}
