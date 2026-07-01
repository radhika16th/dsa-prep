import java.util.List;

public interface Graph {
    // Add a vertex
    public void addVertex(int v);

    // Add an edge
    public void addEdge(int src, int dest);

    // Get neighbors of a vertex
    List<Integer> getNeighbours(int v);

    // Number of vertices
    int size();
}