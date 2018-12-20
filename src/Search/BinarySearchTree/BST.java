package Search.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST<Key extends Comparable<Key>, Value>{
    protected Node root;

    protected class Node{
        Key key;      //用于排序的Key
        Value val;    //节点包含的值
        Node left;
        Node right;
        int N;         // 以该节点为根的子树节点总数
        boolean color; //红黑树中使用

        Node(Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }
        return x.N;
    }
    //用于插入节点之后重新计算树的节点数
    protected void recalculateSize(Node x){
        x.N = size(x.left) + size(x.right) + 1;
    }


    //递归方式查找
    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key){
        if(x == null)
            return null;
        int com = key.compareTo(x.key);
        if(com == 0)
            return x.val;
        else if(com < 0)
            return get(x.left, key);
        else
            return get(x.right, key);
    }

    //迭代方式查找
//        public Value get(Key key){
//            Value result = null;
//            Node node = root;
//            while(node != null){
//                if(key.compareTo(node.key) > 0)
//                    node = node.right;
//                else if(key.compareTo(node.key) < 0)
//                    node = node.left;
//                else {
//                    result = node.val;
//                    break;
//                }
//            }
//            return result;
//        }

    //插入
    public void put(Key key, Value value){
        root = put(root, key ,value);
    }
    private Node put(Node x, Key key, Value value){
        if(x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            x.val = value;
        else if(cmp < 0)
            x.left = put(x.left, key, value);
        else
            x.right = put(x.right, key, value);
        recalculateSize(x);
        return x;
    }

    //查找小于等于键的最大键
    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }
    private Node floor(Node x, Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        else if(cmp < 0)
            return floor(x.left, key);
        else{
            Node t = floor(x.right, key);
            return t != null ? t : x;
        }
    }

    //查找大于等于键的最小键
    public Key ceil(Key key){
        Node x = ceil(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }
    private Node ceil(Node x, Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        else if(cmp > 0)
            return ceil(x.right, key);
        else{
            Node t = ceil(x.left, key);
            return t != null ? t : x;
        }
    }

    //返回key的排名，先左子树再根节点后后右子树.排名从1开始
    //即使树中不包括这个key值，也会寻找相应的位置返回。
    public int rank(Key key){
        return rank(key, root);
    }
    private int rank(Key key, Node x){
        if(x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return size(x.left);
        else if(cmp < 0)
            return rank(key, x.left);
        else
            return 1 + size(x.left) + rank(key, x.right);
    }

    //寻找最小键值
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x == null)
            return null;
        if(x.left == null)
            return x;
        return min(x.left);
    }

    //寻找最大键值
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x == null)
            return null;
        if(x.right == null)
            return x;
        return max(x.right);
    }


    //令指向最小节点的链接指向最小节点的右子树。
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        recalculateSize(x);
        return x;
    }

    //删除一个节点
    public void delete(Key key){
        root = delete(root, key);
    }
    private Node delete(Node x, Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = delete(x.left, key);
        else if(cmp > 0)
            x.right = delete(x.right, key);
        else {
            if(x.right == null)
                return x.left;
            if(x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        recalculateSize(x);
        return x;
    }

    public List<Key> keys(Key l, Key h) {
        return keys(root, l, h);
    }

    private List<Key> keys(Node x, Key l, Key h) {
        List<Key> list = new ArrayList<>();
        if (x == null)
            return list;
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);
        if (cmpL < 0)
            list.addAll(keys(x.left, l, h));
        if (cmpL <= 0 && cmpH >= 0)
            list.add(x.key);
        if (cmpH > 0)
            list.addAll(keys(x.right, l, h));
        return list;
    }

    //中序遍历非递归
    public void nrInOrderTraverse(){
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                System.out.print(node.val+" ");
                node = node.right;
            }
        }
    }
    //中序遍历递归
    public void inOrderTraverse(Node x){
        if(x != null){
            inOrderTraverse(x.left);
            System.out.print(x.val+" ");
            inOrderTraverse(x.right);
        }
    }

    //先序遍历非递归
    public void nrPreOrderTraverse(){
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.right;
            }
        }
    }
    //先序遍历递归
    public void preOrderTraverse(Node x){
        if(x != null){
            System.out.print(x.val + " ");
            preOrderTraverse(x.left);
            preOrderTraverse(x.right);
        }
    }

    //后序遍历非递归
    public void nrPostOrderTraverse(){
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.val + " ");
            //这里需要判断一下，当前node是否为栈顶的左子树，如果是的话那么还需要先访问右子树才能访问根节点
            //如果已经是不是左子树的话，那么说明左右子书都已经访问完毕，可以访问根节点了，所以讲node赋值为null
            //取根节点
            if(!stack.isEmpty() && node == stack.peek().left){
                node = stack.peek().right;
            }else {
                node = null;
            }
        }
    }

    //后序遍历递归
    public void postOrderTraverse(Node x){
        if(x != null){
            postOrderTraverse(x.left);
            postOrderTraverse(x.right);
            System.out.print(x.val + " ");
        }
    }
}
