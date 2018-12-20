package Search.AVL23Tree;

public class Tree23{
    private Node root;

    private class KeyItem{
        private int keyItem;

        public int getKeyItem() {
            return keyItem;
        }

        public void setKeyItem(int keyItem) {
            this.keyItem = keyItem;
        }
    }
    private class ValueItem{
        private int valueItem;

        public int getValueItem() {
            return valueItem;
        }

        public void setValueItem(int valueItem) {
            this.valueItem = valueItem;
        }
    }
    private class Node{
        private static final int ORDER = 3;  //节点最多有三个子节点
        private KeyItem[] keyItem = new KeyItem[ORDER - 1]; //节点用来排序的键
        private ValueItem[] valueItem = new ValueItem[ORDER - 1]; //节点元素的值
        private int itemNum;  //节点包含元素的个数
        private Node parent;  //节点的父节点
        private Node[] childArray = new Node[ORDER]; //节点的子节点数组

        public int getItemNum(){
            return itemNum;
        }

        //找到关键字在本节点中的位置
        public int findKey(int key){
            for(int i = 0; i < ORDER - 1; i++){
                if(keyItem[i] == null)
                    break;
                else if(keyItem[i].getKeyItem() == key)
                    return i;
            }
            return -1;
        }

        //判断节点是否是叶子节点
        public boolean isLeaf(){
            return (childArray[0] == null) ? true : false;
        }

        //得到当前节点的某个叶子节点
        public Node getChild(int childNum){
            return childArray[childNum];
        }

        //得到当前节点的某个Key元素
        public KeyItem getKeyItem(int index){
            return keyItem[index];
        }
    }

    //查找关键字
    public int get(int key){
        Node x = root;
        int childNum;
        if(x == null)
            return -1;
        while(true){
            if((childNum = x.findKey(key)) != -1)
                return childNum;
            else if(x.isLeaf())
                return -1;
            else
                x = getNextChild(x, key);
        }
    }

    //根据关键字的大小找到合适的子节点
    public Node getNextChild(Node x, int key){
        int i;
        int itemNum = x.getItemNum();
        for(i = 0; i < itemNum; i++){
            if(key < x.getKeyItem(i).getKeyItem()){
                return x.getChild(i);
            }
        }
        return x.getChild(i);
    }
}
