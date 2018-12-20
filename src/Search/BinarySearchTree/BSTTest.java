package Search.BinarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        //BST.Node root = new BST<Integer, Integer>().new Node();
        BST bsTree = new BST<Integer, Integer>();
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] keys = {4, 7, 2, 1, 10, 6, 9, 3, 8};
        for(int i = 0; i < keys.length; i++){
            bsTree.put(keys[i], values[i]);
        }

        System.out.println();
        bsTree.nrInOrderTraverse();
        System.out.println();
        bsTree.inOrderTraverse(bsTree.root);

        System.out.println();
        System.out.println();
        bsTree.nrPreOrderTraverse();
        System.out.println();
        bsTree.preOrderTraverse(bsTree.root);

        System.out.println();
        System.out.println();
        bsTree.nrPostOrderTraverse();
        System.out.println();
        bsTree.postOrderTraverse(bsTree.root);

        System.out.println();
        System.out.println("zise = " + bsTree.size());

        Integer key1 = (Integer)bsTree.get(2);
        System.out.println("value = "+ key1+ " where key is 2");

        bsTree.put(11, 11);
        System.out.println();
        System.out.println("size = " + bsTree.size());

        System.out.println();
        bsTree.nrInOrderTraverse();

        bsTree.put(0, 12);
        System.out.println();
        System.out.println("size = " + bsTree.size());

        System.out.println();
        bsTree.nrInOrderTraverse();

        System.out.println();
        Integer key2 = (Integer) bsTree.floor(5);
        System.out.println("5 floor is : "+ key2);

        System.out.println();
        Integer key3 = (Integer) bsTree.ceil(5);
        System.out.println("5 ceil is : "+ key3);

        System.out.println();
        Integer index = bsTree.rank(2);
        System.out.println("index of key 5 is: "+ index);

        System.out.println();
        Integer minKey = (Integer) bsTree.min();
        System.out.println("min key is: "+ minKey);

        System.out.println();
        Integer maxKey = (Integer) bsTree.max();
        System.out.println("min key is: "+ maxKey);

        System.out.println();
        bsTree.delete(0);
        System.out.println();
        bsTree.delete(11);
        System.out.println();

        System.out.println();
        System.out.println("size = " + bsTree.size());

        System.out.println();
        bsTree.delete(4);
        System.out.println("size = " + bsTree.size());
        System.out.println();
        bsTree.nrInOrderTraverse();
    }
}
