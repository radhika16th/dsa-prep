import java.util.*;

public class AdjacencyListGraph implements Graph {
    private Map<Integer, List<Integer>> adjList;

    public AdjacencyListGraph() {
        adjList = new HashMap<>();
    }

    @Override
    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    @Override
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());

        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    @Override
    public List<Integer> getNeighbours(int v) {
        return adjList.getOrDefault(v, new ArrayList<>());
    }

    public int size() {
        return adjList.size();
    }

    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    public void printGraphs() {
        for (int v : adjList.keySet()) {
            System.out.println(v + " -> " + adjList.get(v));
        }
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();


        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("Graph :");
        graph.printGraphs();

        System.out.println("BFS: ");
        BFS.bfs(graph, 0);

        System.out.println();

        System.out.println("DFS: ");
        DFS.dfs(graph, 0);
    }
}