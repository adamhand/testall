package LeetCode.test86_PartitionList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class PartitionList {
//    public ListNode partition(ListNode head, int x) {
//        if(head == null || head.next == null)
//            return head;
//        ListNode nHead = new ListNode(0);
//        ListNode nTail = new ListNode(0);
//        ListNode cur = head, curH = nHead, curT = nTail;
//        while (cur != null){
//            if(cur.val < x){
//                ListNode node = new ListNode(cur.val);
//                node.next = curH.next;
//                curH.next = node;
//                curH = curH.next;
//            }else {
//                ListNode node = new ListNode(cur.val);
//                node.next = curT.next;
//                curT.next = node;
//                curT = curT.next;
//            }
//            cur = cur.next;
//        }
////        cur = nHead;
////        while (cur.next != null)
////            cur = cur.next;
////        cur.next = nTail.next;
//
//        curH.next = nTail.next;
//
//        return nHead.next;
//    }

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1, cur2 = dummy2;
        while (head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = head;
            }else {
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = dummy2.next;

        return dummy1.next;
    }
}
