package LeetCode.test138_CopyListwithRandomPointer;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class Solution {
    Map<RandomListNode, RandomListNode> visited = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;

        RandomListNode oldNode = head;
        RandomListNode newNode = new RandomListNode(oldNode.label);
        visited.put(oldNode, newNode);

        while (oldNode != null){
            newNode.random = getCloneNode(oldNode.random);
            newNode.next = getCloneNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return visited.get(head);
    }

    public RandomListNode getCloneNode(RandomListNode node){
        if(node != null){
            if(visited.containsKey(node)){
                return visited.get(node);
            }else {
                visited.put(node, new RandomListNode(node.label));
                return visited.get(node);
            }
        }
        return null;
    }
}
