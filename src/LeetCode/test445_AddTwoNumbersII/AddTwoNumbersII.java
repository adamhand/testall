package LeetCode.test445_AddTwoNumbersII;

import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if(l1 == null && l2 == null)
            return null;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode a = l1, b = l2;
        while (a != null){
            stack1.push(a.val);
            a = a.next;
        }
        while (b != null){
            stack2.push(b.val);
            b = b.next;
        }

        ListNode nHead = new ListNode(0);
        int sum = 0;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty())
                sum += stack1.pop();
            if(!stack2.isEmpty())
                sum += stack2.pop();

            sum += carry;
            ListNode node = new ListNode(sum % 10);
            node.next = nHead.next;
            nHead.next = node;

            carry = sum / 10;
            sum = 0;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = nHead.next;
            nHead.next = node;
        }

        return nHead.next;
    }
}
