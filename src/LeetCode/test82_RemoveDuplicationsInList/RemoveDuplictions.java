package LeetCode.test82_RemoveDuplicationsInList;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class RemoveDuplictions {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        if(head.val == head.next.val){
            ListNode node = head.next;
            while(node != null && node.val == head.val){
                node = node.next;
            }
            return deleteDuplicates(node);
        }else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
