package LeetCode.test817_LinkedListComponents;


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int i : G){
            set.add(i);
        }

        ListNode cur = head;
        int ans = 0;

        while (cur != null){
            if(set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))){
                ans++;
            }
            cur = cur.next;
        }
        return ans;
    }
}
