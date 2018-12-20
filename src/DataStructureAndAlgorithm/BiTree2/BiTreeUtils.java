package DataStructureAndAlgorithm.BiTree2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


//二叉树的各种方法，构建和遍历等
public class BiTreeUtils {
    /**
     * 先序构建二叉树。从键盘输入数的节点的值，输入-1代表节点为null。
     * 例如：              8
     *                   / \
     *                  8   7
     *                 /\
     *                9  2
     *                  /\
     *                 4  7
     * 从键盘输入应为：8 8 9 -1 -1 2 4 -1 -1 7 -1 -1 7 -1 -1(真正输入时空格为Enter，即输入一个数字换一下行)
     */
    public static BiTreeNode createBiTreePreOrder(BiTreeNode root){
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        if(val == -1)
            root = null;
        else {
            root = new BiTreeNode(val);
            root.setLeft(createBiTreePreOrder(root.getLeft()));
            root.setRight(createBiTreePreOrder(root.getRight()));
        }
        return root;
    }

    //中序遍历非递归
    public static void nrInOrderTraverse(BiTreeNode node){
        Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.getLeft();
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                System.out.print(node.getValue()+" ");
                node = node.getRight();
            }
        }
    }

    //中序遍历递归
    public static void inOrderTraverse(BiTreeNode x){
        if(x != null){
            inOrderTraverse(x.getLeft());
            System.out.print(x.getValue()+" ");
            inOrderTraverse(x.getRight());
        }
    }

    //先序遍历非递归
    public static void nrPreOrderTraverse(BiTreeNode node){
        Stack<BiTreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                System.out.print(node.getValue() + " ");
                stack.push(node);
                node = node.getLeft();
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.getRight();
            }
        }
    }
    //先序遍历递归
    public static void preOrderTraverse(BiTreeNode x){
        if(x != null){
            System.out.print(x.getValue() + " ");
            preOrderTraverse(x.getLeft());
            preOrderTraverse(x.getRight());
        }
    }

    //后序遍历非递归
    public static void nrPostOrderTraverse(BiTreeNode node){
        Stack<BiTreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            System.out.print(node.getValue() + " ");
            //这里需要判断一下，当前node是否为栈顶的左子树，如果是的话那么还需要先访问右子树才能访问根节点
            //如果已经是不是左子树的话，那么说明左右子书都已经访问完毕，可以访问根节点了，所以讲node赋值为null
            //取根节点
            if(!stack.isEmpty() && node == stack.peek().getLeft()){
                node = stack.peek().getRight();
            }else {
                node = null;
            }
        }
    }

    //后序遍历递归
    public static void postOrderTraverse(BiTreeNode x){
        if(x != null){
            postOrderTraverse(x.getLeft());
            postOrderTraverse(x.getRight());
            System.out.print(x.getValue() + " ");
        }
    }

    //层次遍历
    public static void levelOrder(BiTreeNode root){
        Queue<BiTreeNode> queue = new LinkedList<>();
        BiTreeNode temp;
        if(root != null)
            queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.getValue()+" ");
            if(null != temp.getLeft())
                queue.offer(temp.getLeft());
            if(null != temp.getRight())
                queue.offer(temp.getRight());
        }
    }
}
