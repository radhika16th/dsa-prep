import java.util.*;

/**
 * Implements a Graph using an Adjacency List.
 *
 * Idea:
 * - Each vertex maps to a list of its neighbors
 * - Efficient for sparse graphs
 *
 * Uses:
 * - adjList: Map storing vertex → list of neighbors
 *
 * Operations:
 * - addVertex: adds a vertex
 * - addEdge: adds a directed edge
 * - getNeighbours: returns neighbors of a vertex
 *
 * Time Complexity:
 * - addVertex: O(1)
 * - addEdge: O(1)
 * - getNeighbours: O(1)
 *
 * Space Complexity:
 * - O(V + E)
 */

public class AdjacencyListGraph implements Graph {
    // Map to store adjacency list
    private Map<Integer, List<Integer>> adjList;

    /**
     * Constructor initializes empty graph
     */
    public AdjacencyListGraph() {
        adjList = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph
     */
    @Override
    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    /**
     * Adds a directed edge from src → dest
     */
    @Override
    public void addEdge(int src, int dest) {
        // Ensure both vertices exist
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());

        // Add edge
        adjList.get(src).add(dest);
    }

    /**
     * Returns neighbors of a vertex
     */
    @Override
    public List<Integer> getNeighbours(int v) {
        return adjList.getOrDefault(v, new ArrayList<>());
    }

    /**
     * Returns number of vertices
     */
    @Override
    public int size() {
        return adjList.size();
    }

    /**
     * Returns all vertices
     */
    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    /**
     * Prints the graph
     */
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


        AdjacencyListGraph g = new AdjacencyListGraph();

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // SCC 1

        g.addEdge(1, 3);
        g.addEdge(3, 4); // SCC 2

        System.out.println("\n\nStrongly Connected Components:");
        SCC.findSCCs(g);

    }
}