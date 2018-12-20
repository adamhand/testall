package LeetCode.test83_RemoveDuplicatesfromSortedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveDuplicates {
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null)
//            return head;
//
//        ListNode cur = head;
//        while (cur != null && cur.next  != null){
//            if(cur.val == cur.next.val)
//                cur.next = cur.next.next;
//            else
//                cur = cur.next;
//        }
//
//        return head;
//    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
