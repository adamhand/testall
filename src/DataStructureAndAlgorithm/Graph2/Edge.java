package DataStructureAndAlgorithm.Graph2;

public class Edge<T> {
    T beginVertice;
    T endVertice;
    int cost;

    public Edge(T beginVertice, T endVertice, int cost) {
        this.beginVertice = beginVertice;
        this.endVertice = endVertice;
        this.cost = cost;
    }
}
