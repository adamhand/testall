package LeetCode.test206_ReverseLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode nHead = new ListNode(0);
        ListNode pNode = head;
        while (pNode != null){
            ListNode next = pNode.next;
            pNode.next = nHead.next;
            nHead.next = pNode;
            pNode = next;
        }

        return nHead.next;
    }
}
