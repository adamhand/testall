package LeetCode.test147_InsertionSortList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode cur = head, next = null;
        ListNode l = new ListNode(0);

        while(cur != null){
            //保存一下下一个节点的值
            next = cur.next;
            ListNode p = l;
            while(p.next != null && p.next.val < cur.val)
                p = p.next;

            //将cur插入到p的后面
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return l.next;
    }
}
