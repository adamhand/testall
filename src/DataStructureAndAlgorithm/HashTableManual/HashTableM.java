package DataStructureAndAlgorithm.HashTableManual;

//参考：https://yq.aliyun.com/articles/669642
public class HashTableM<K, V> {
    private int size;   //表容量
    private static final float loadFactor = 0.75f;   //装填因子
    private float threshode;    //扩容阈值
    private Node[] nodes;

    public HashTableM(int size){
        this.size = size;
        nodes = new Node[size];
        threshode = size * loadFactor;
    }

    private class Node<K, V>{
        K k;
        V v;
        Node<K, V> next;

        public Node(){
        }

        public Node(K k, V v){
            this.k = k;
            this.v = v;
        }

        public Node(K k, V v, Node<K, V> next){
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    public int hash(K key){
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public void put(K key, V value){
        if(key == null){
            handleNullValue(value);
            return;
        }

        int h = hash(key);
        int i = indexFor(h, nodes.length);
        for(Node<K, V> node = nodes[i]; node != null; node = node.next){
            if(node.k == key){
                node.v = value;
            }
        }

        addNode(i, key, value);
    }

    public V get(K key){
        if(key == null){
            return findNullKeyValue();
        }

        int h = hash(key);
        int i = indexFor(h, nodes.length);
        for(Node<K, V> node = nodes[i]; node != null; node = node.next){
            if(node.k == key){
                return node.v;
            }
        }

        return null;
    }

    private V findNullKeyValue(){
        for(Node<K, V> node = nodes[0]; node != null; node = node.next){
            if(node.k == null){
                return node.v;
            }
        }
        return null;
    }

    private void addNode(int i, K key, V value){
        Node<K, V> node = nodes[i];
        Node<K, V> newNode = new Node(key, value);

        //如果链表为空，就新建链表
        if(node == null){
            node = new Node<>();
            nodes[i] = node;
            node.next = null;
        }

        Node nodeNext = node.next;
        node.next = newNode;
        newNode.next = nodeNext;
    }

    private int indexFor(int h, int length){
        return h % length;
    }

    private void handleNullValue(V value){
        for(Node<K, V> node = nodes[0]; node != null; node = node.next){
            if(node.k == null){
                node.v = value;
            }
        }
    }
}
