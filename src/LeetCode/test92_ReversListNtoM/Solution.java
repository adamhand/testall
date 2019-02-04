package LeetCode.test92_ReversListNtoM;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        ListNode back = dummy;
        int i = 1;

        while (i < m){
            pre = pre.next;
            i++;
        }
        cur = pre.next;

        while (i <= n){
            stack.push(cur);
            cur = cur.next;
            i++;
        }
        back = cur;

        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            pre.next = node;
            pre = pre.next;
        }
        pre.next = back;

        return dummy.next;

    }
}
