package DataStructureAndAlgorithm.Graph;

import java.util.LinkedList;

//顶点的数据结构，采用邻接表的结构存储
public class Vertex {
    LinkedList<Vertex> adj; //顶点邻接表
    int data;               //顶点中存储的数据
    int color;              //0=white, 1=gray, 2=black
    int distance;           //from start vertex
    Vertex parent;
    int discoveryTime;
    int finishTime;
    boolean extracted;

    public Vertex(int data){
        this.data=data;
        color=0;
        distance=-1;
        parent=null;
        adj = new LinkedList<>();
        discoveryTime=0;
        finishTime=0;
    }
}
