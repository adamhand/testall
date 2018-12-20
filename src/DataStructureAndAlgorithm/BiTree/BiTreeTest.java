package DataStructureAndAlgorithm.BiTree;

public class BiTreeTest {
    public static void main(String[] args) {
        BiTree biTree = new BiTree();

//        biTree.createBiTreePreOrder(biTree.root);   //这样不行，没有返回，方法完成之后堆销毁
        biTree.createBiTreePreOrder();

//        biTree.createBiTreeInOrder();

        biTree.preOrderTraverse(biTree.root);

        System.out.println();
        biTree.levelOrder(biTree.root);
    }
}
