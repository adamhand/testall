package DataStructureAndAlgorithm.BiTree2;

public class BiTreeTest {
    public static void main(String[] args) {
        BiTreeNode root = null;
        root = BiTreeUtils.createBiTreePreOrder(root);

        //先序遍历
        BiTreeUtils.nrPreOrderTraverse(root);
        System.out.println();
        BiTreeUtils.preOrderTraverse(root);
        System.out.println();

        //中序遍历
        BiTreeUtils.nrInOrderTraverse(root);
        System.out.println();
        BiTreeUtils.inOrderTraverse(root);
        System.out.println();


        //后序遍历
        BiTreeUtils.nrPostOrderTraverse(root);
        System.out.println();
        BiTreeUtils.postOrderTraverse(root);
        System.out.println();


        //层次遍历
        BiTreeUtils.levelOrder(root);
        System.out.println();
    }
}
