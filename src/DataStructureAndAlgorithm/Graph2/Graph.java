package DataStructureAndAlgorithm.Graph2;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T> {
    int size;            //图的顶点数目
    int[][] arcs;        //邻接矩阵
    T[] verticeInro;     //顶点信息
    int[] visited;       //顶点是否被访问，1表示已经被访问；0表示还没被访问

    /**
     * @param verticeInro：顶点信息
     * @param edges：边
     * @param isDirected：false代表无向图；true代表有向图
     */
    public Graph(T[] verticeInro, Edge<T>[] edges, boolean isDirected){
        this.verticeInro = verticeInro;
        this.size = verticeInro.length;
        visited = new int[size];

        arcs = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j)
                    arcs[i][j] = 0;
                else
                    arcs[i][j] = Integer.MAX_VALUE;
            }
        }

        for(Edge e : edges){
            int begin = findIndex((T)e.beginVertice, verticeInro);
            int end = findIndex((T)e.endVertice, verticeInro);
            arcs[begin][end] = e.cost;
            //如果是无向图，A到B和B到A距离相等；如果是有向图，且方向是从A到B，则B到A的距离为无穷。
            if(!isDirected)
                arcs[end][begin] = e.cost;
        }
    }

    /**
     * 找出数组中指定元素的位置，如果找不到，就返回-1.这个函数可能存在数组角标越界的情况
     * @param vertice
     * @param verticeInro
     * @return
     */
    private int findIndex(T vertice, T[] verticeInro){
        for(int i = 0; i < verticeInro.length; i++){
            if(vertice.equals(verticeInro[i]))
                return i;
        }
        return -1;
    }

    public void print(){
        for(int i = 0; i < arcs.length; i++){
            int[] ii = arcs[i];
            System.out.print(verticeInro[i] + "  ");
            for(int j : ii)
                System.out.printf("%-16d", j);
            System.out.println();
        }
    }

    //将visited数组初始化为0
    private void initVisited(){
        for(int i = 0; i < size; i++)
            visited[i] = 0;
    }

    /**
     * 寻找还没有被访问过的点，如果还有，返回顶点编号(>=0)；否则返回-1
     * @return
     */
    private int findNotVisited(){
        for(int i = 0; i < size; i++){
            if(visited[i] == 0)
                return i;
        }
        return -1;
    }

    /**
     * 深度优先递归
     */
    private void DFS(int start, Queue<T> vertice){
        visited[start] = 1;
        vertice.offer(verticeInro[start]);
        for(int i = 0; i < size; i++){           //遍历相邻节点
            if(arcs[start][i] != Integer.MAX_VALUE && visited[i] == 0)
                DFS(i, vertice);
        }
    }

    public Queue<T> deepthFirstSearch(){
        initVisited();
        Queue<T> vertice = new LinkedList<>();   //用于存储遍历过的点,用于返回
        int start = -1;
        while((start = findNotVisited()) != -1)
            DFS(start, vertice);
        return vertice;
    }

    /**
     * 广度优先遍历，使用队列实现
     */
    public Queue<T> breadthFirstSearch(){
        initVisited();
        Queue<Integer> tempQueue = new LinkedList<>();   //辅助数组
        Queue<T> vertice = new LinkedList<>();     //依次存储访问过的顶点，用于返回
        int curVerticeIndex = -1;
        while((curVerticeIndex = findNotVisited()) != -1){
            if(visited[curVerticeIndex] == 0){
                tempQueue.offer(curVerticeIndex);
                while(!tempQueue.isEmpty()){
                    curVerticeIndex = tempQueue.poll();
                    if(!vertice.contains(verticeInro[curVerticeIndex]))  //注意需要检查队列中是否包含j，否则会出现重复现象。
                        vertice.offer(verticeInro[curVerticeIndex]);
                    visited[curVerticeIndex] = 1;
                    for(int j = 0; j < size; j++){                 //遍历所有相邻节点
                        if(arcs[curVerticeIndex][j] != Integer.MAX_VALUE && visited[j] == 0)
                            tempQueue.offer(j);
                    }
                }
            }
        }
        return vertice;
    }
}
