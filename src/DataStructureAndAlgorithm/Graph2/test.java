package DataStructureAndAlgorithm.Graph2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Graph<String> graph = createGraph(true);
        System.out.println("图的邻接矩阵如下：");
        graph.print();

        System.out.println("深度遍历结果如下：");
        Queue<String> ds = graph.deepthFirstSearch();
        System.out.println(ds);

        System.out.println("广度遍历结果如下：");
        Queue<String> bs = graph.breadthFirstSearch();
        System.out.println(bs);
    }

    /**
     * 是否生成有向图
     * @param isDirected
     */
    public static Graph createGraph(boolean isDirected) {
        String[] vertices = new String[]{"北京", "上海", "广州", "重庆", "武汉", "南昌"};

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge("北京", "广州", 10));
        edgeList.add(new Edge("北京", "上海", 11));
        edgeList.add(new Edge("上海", "南昌", 6));
        edgeList.add(new Edge("广州", "重庆", 14));
        edgeList.add(new Edge("广州", "武汉", 9));
        edgeList.add(new Edge("重庆", "武汉", 20));
        edgeList.add(new Edge("武汉", "北京", 13));
        edgeList.add(new Edge("武汉", "南昌", 12));
        edgeList.add(new Edge("南昌", "广州", 18));

        Edge[] edgeArray = new Edge[edgeList.size()];

        return new Graph<String>(vertices, edgeList.toArray(edgeArray), isDirected);
    }
}
