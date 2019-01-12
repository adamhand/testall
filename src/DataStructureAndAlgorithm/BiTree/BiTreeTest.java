package DataStructureAndAlgorithm.BiTree;

import java.util.ArrayList;
import java.util.List;

public class BiTreeTest {
    public static void main(String[] args) {
        BiTree biTree = new BiTree();

//        biTree.createBiTreePreOrder(biTree.root);   //这样不行，没有返回，方法完成之后堆销毁
        biTree.createBiTreePreOrder();

//        biTree.createBiTreeInOrder();

        List list = new ArrayList();

        list = biTree.preOrderTraverse(biTree.root, list);
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i)+" ");

        System.out.println();
        biTree.levelOrder(biTree.root);
    }
}
