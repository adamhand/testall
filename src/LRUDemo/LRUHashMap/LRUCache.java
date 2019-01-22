package LRUDemo.LRUHashMap;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 使用HashMap存储元素。
 * 使用一个双链表辅助存储元素。每当对元素进行了操作，会将元素放到链表头部。如果超出链表的
 * size要求，就从尾部删除。这样就做到了最近使用的元素在链表头部，而没有使用的会被删除。
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> implements Iterable<K> {
    private Node head;         //双链表的头结点，不存储值
    private Node tail;         //双链表的尾结点，不存储值
    private int size;          //链表的最大容量
    private float loadFactor = 0.75f;  //HashMap中的容量为size * loadFactor
    private HashMap<K, Node> map;

    private class Node{
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v){
            this.k = k;
            this.v = v;
        }
    }

    public LRUCache(int size){
        this.size = size;
        map = new HashMap<K, Node>((int)(size * loadFactor));

        head = new Node(null, null);
        tail = new Node(null, null);

        //构建一个空的双链表
        head.next = tail;
        tail.next = head;
    }

    public V get(K key){
        if(! map.containsKey(key)){
            return null;
        }

        Node node = map.get(key);
        unlink(node);
        appendHead(node);

        return node.v;
    }

    public void put(K key, V value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);

        if(map.size() > size){
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }

    //将当前元素在双链表中断开
    private void unlink(Node node){
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }

    //将当前节点加入链表头
    private Node appendHead(Node node){
//        unlink(node);

        Node headNext = head.next;
        head.next = node;
        node.next = headNext;

        headNext.pre = node;
        node.pre = head;

        return node;
    }

    //删除链表尾部的节点
    private Node removeTail(){
        Node node = tail.pre;
        Node pre = node.pre;

        tail.pre = pre;
        pre.next = tail;

        node.pre = null;
        node.next = null;

        return node;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }

            @Override
            public void remove() {

            }
        };
    }
}
