package LeetCode.test61_RotateList;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RotateList {
//    public ListNode rotateRight(ListNode head, int k) {
//        if(head == null || head.next == null)
//            return head;
//        Stack<ListNode> stack1 = new Stack<>();
//        Stack<ListNode> stack2 = new Stack<>();
//        Stack<ListNode> stack3 = new Stack<>();
//
//        while (head != null){
//            stack1.push(head);
//            head = head.next;
//        }
//        int length = k % stack1.size();
//        for(int i = 0; i < length; i++)
//            stack2.push(stack1.pop());
//        while (!stack1.isEmpty())
//            stack3.push(stack1.pop());
//
//        ListNode nHead = new ListNode(0);
//        ListNode cur = nHead;
//        while (!stack2.isEmpty()){
//            ListNode node = stack2.pop();
//            cur.next = node;
//            cur = cur.next;
//        }
//        while (!stack3.isEmpty()){
//            ListNode node = stack3.pop();
//            cur.next = node;
//            cur = cur.next;
//        }
//
//        return nHead.next;
//    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode nHead = new ListNode(0);
        nHead.next = head;
        ListNode fast = nHead, slow = nHead;

        int i;
        for(i = 0; fast.next != null; i++)
            fast = fast.next;

        for(int j = i - k % i; j > 0; j--)
            slow = slow.next;

        fast.next = nHead.next;
        nHead.next = slow.next;
        slow.next = null;

        return nHead.next;
    }

}
