package LeetCode.test876_MiddleoftheLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
