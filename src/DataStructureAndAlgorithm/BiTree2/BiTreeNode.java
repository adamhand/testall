package DataStructureAndAlgorithm.BiTree2;

public class BiTreeNode {
    private int value;
    private BiTreeNode left;
    private BiTreeNode right;

    public BiTreeNode(){}

    public BiTreeNode(int value){
        this.value = value;
    }

    public BiTreeNode(int value, BiTreeNode left, BiTreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BiTreeNode getLeft() {
        return left;
    }

    public void setLeft(BiTreeNode left) {
        this.left = left;
    }

    public BiTreeNode getRight() {
        return right;
    }

    public void setRight(BiTreeNode right) {
        this.right = right;
    }
}
