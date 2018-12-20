package LeetCode.test148_SortList;

import javax.print.attribute.standard.NumberUp;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SortList {
    //用堆不行，因为堆的左右节点是无序的。
//    public ListNode sortList(ListNode head) {
//        if(head == null || head.next == null)
//            return null;
//
//        //小顶堆
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return Integer.compare(o1.val, o2.val);
//            }
//        });
//
//        ListNode pNode = head;
//        while(pNode != null){
//            queue.add(pNode);
//            pNode = pNode.next;
//        }
//
//        ListNode temp = queue.poll();
//        if(!queue.isEmpty())
//            temp = queue.poll();
//
//        ListNode result = new ListNode(temp.val);
//        while (!queue.isEmpty())
//            result.next = queue.poll();
//
//        return result;
//    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        //将链表进行拆分。
        ListNode fast = head, slow = head, pre = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1 ,l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode moving = dummy;

        while (l1 != null && l2 !=  null){
            if(l1.val < l2.val){
                moving.next = l1;
                l1 = l1.next;
            }else {
                moving.next = l2;
                l2 = l2.next;
            }
            moving = moving.next;
        }
        if(l1 != null)
            moving.next = l1;
        if(l2 != null)
            moving.next = l2;

        return dummy.next;
    }
}
