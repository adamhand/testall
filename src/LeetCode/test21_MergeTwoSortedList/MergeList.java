package LeetCode.test21_MergeTwoSortedList;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}

public class MergeList {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        if(l1 == null && l2 == null)
//            return null;
//        if(l1 == null)
//            return l2;
//        if(l2 == null)
//            return l1;
//
//        ListNode pHead1 = l1, pHead2 = l2;
//        ListNode l3 = new ListNode(0), lHead = l3;
//        while(pHead1 != null && pHead2 != null){
//            if(pHead1.val < pHead2.val){
//                l3.next = new ListNode(pHead1.val);
//                l3 = l3.next;
//                pHead1 = pHead1.next;
//            }else {
//                l3.next = new ListNode(pHead2.val);
//                l3 = l3.next;
//                pHead2 = pHead2.next;
//            }
//        }
//        while(pHead1 != null){
//            l3.next = new ListNode(pHead1.val);
//            l3 = l3.next;
//            pHead1 = pHead1.next;
//        }
//        while(pHead2 != null){
//            l3.next = new ListNode(pHead2.val);
//            l3 = l3.next;
//            pHead2 = pHead2.next;
//        }
//
//        return lHead.next;
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode l3 = new ListNode(0), pHead = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pHead.next = l1;
                l1 = l1.next;
            }else {
                pHead.next = l2;
                l2 = l2.next;
            }
            pHead = pHead.next;
        }
        if(l1 != null)
            pHead.next = l1;
        if(l2 != null)
            pHead.next = l2;

        return l3.next;
    }
}
