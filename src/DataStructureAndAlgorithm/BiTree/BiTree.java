package DataStructureAndAlgorithm.BiTree;

import java.util.*;

public class BiTree {
    protected BiTreeNode root;

    //节点数据结构
    protected class BiTreeNode{
        int        value;
        BiTreeNode left;
        BiTreeNode right;

        public BiTreeNode(){}

        public BiTreeNode(int value){
            this.value = value;
        }

        public BiTreeNode(int value, BiTreeNode left, BiTreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //先序构建二叉树递归
    public void createBiTreePreOrder(){
        root = createBiTreePreOrder(root);
    }

    public BiTreeNode createBiTreePreOrder(BiTreeNode node){
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        if(val == -1)
            return null;
        else {
            node = new BiTreeNode(val);
            node.left = createBiTreePreOrder(node.left);
            node.right = createBiTreePreOrder(node.right);
        }
        return node;
    }

//    //中序构建二叉树递归
//    public void createBiTreeInOrder(){
//        root = createBiTreePreOrder(root);
//    }
//
//    public BiTreeNode createBiTreeInOrder(BiTreeNode node){
//        Scanner scanner = new Scanner(System.in);
//        int val = scanner.nextInt();
//        if(val == -1)
//            return null;
//        else {
//            node.left = createBiTreePreOrder(node.left);
//            node = new BiTreeNode(val);
//            node.right = createBiTreePreOrder(node.right);
//        }
//        return node;
//    }

    //中序遍历非递归
    public void nrInOrderTraverse(){
        Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
        BiTreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                System.out.print(node.value+" ");
                node = node.right;
            }
        }
    }

    //中序遍历递归
    public void inOrderTraverse(BiTreeNode x){
        if(x != null){
            inOrderTraverse(x.left);
            System.out.print(x.value+" ");
            inOrderTraverse(x.right);
        }
    }

    //先序遍历非递归
    public void nrPreOrderTraverse(){
        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                System.out.print(node.value + " ");
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
//    public void preOrderTraverse(BiTreeNode x){
//        if(x != null){
//            System.out.print(x.value + " ");
//            preOrderTraverse(x.left);
//            preOrderTraverse(x.right);
//        }
//    }

    /**
     * 不直接输出，而是保存到一个链表里
     * @param x
     * @param list
     * @return
     */
    public List preOrderTraverse(BiTreeNode x,List list){
        if(x != null){
            list.add(x.value);
            list = preOrderTraverse(x.left, list);
            list = preOrderTraverse(x.right, list);
        }

        return list;
    }

    //后序遍历非递归
    public void nrPostOrderTraverse(){
        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.value + " ");
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
    public void postOrderTraverse(BiTreeNode x){
        if(x != null){
            postOrderTraverse(x.left);
            postOrderTraverse(x.right);
            System.out.print(x.value + " ");
        }
    }

    //层次遍历
    public void levelOrder(BiTreeNode root){
        Queue<BiTreeNode> queue = new LinkedList<>();
        BiTreeNode temp;
        if(root != null)
            queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.value+" ");
            if(null != temp.left)
                queue.offer(temp.left);
            if(null != temp.right)
                queue.offer(temp.right);
        }
    }
}
