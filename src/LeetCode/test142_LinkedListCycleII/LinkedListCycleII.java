package LeetCode.test142_LinkedListCycleII;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedListCycleII {
    //方法1：求得环的长度
//    public ListNode detectCycle(ListNode head) {
//        if(head == null || head.next == null)
//            return null;
//
//        ListNode meetingNode = findMeetingNode(head);
//        if(meetingNode == null)
//            return null;
//
//        ListNode node = meetingNode;
//        int nodeInLoop = 1;
//        while (node.next != meetingNode){
//            node = node.next;
//            nodeInLoop++;
//        }
//
//        node = head;
//        for(int i = 0; i < nodeInLoop; i++)
//            node = node.next;
//
//        ListNode node2 = head;
//        while (node != node2){
//            node = node.next;
//            node2 = node2.next;
//        }
//
//        return node;
//    }

    //方法2：不用求得环的长度
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode meetingNode = findMeetingNode(head);
        if(meetingNode == null)
            return null;

        ListNode node1 = head;
        ListNode node2 = meetingNode;

        while (node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    private ListNode findMeetingNode(ListNode head){
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return fast;
        }
        return null;
    }
}
