package LeetCode.test146_LRUCache;

import java.util.HashMap;

public class LRUCache {
    private Node head;
    private Node tail;
    private int size;
    private final float loadFactor = 0.75f;
    private HashMap<Integer, Node> map;

    class Node{
        Node pre;
        Node next;
        int k;
        int v;
        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }

    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<Integer, Node>((int) (capacity * loadFactor));

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        unlink(node);
        appentHead(node);

        return node.v;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        appentHead(node);

        if (map.size() > size){
            Node nodeToRemove = removeTail();
            map.remove(nodeToRemove.k);
        }
    }

    private void unlink(Node node){
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }

    private void appentHead(Node node){
        Node headNext = head.next;

        head.next = node;
        node.next = headNext;

        node.pre = head;
        headNext.pre = node;
    }

    private Node removeTail(){
        Node cur = tail.pre;
        Node pre = cur.pre;

        pre.next = tail;
        tail.pre = pre;

        cur.pre = null;
        cur.next = null;

        return cur;
    }
}
