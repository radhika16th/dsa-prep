import java.util.List;

/**
 * Graph Interface
 *
 * Idea:
 * - Defines core operations for a graph
 * - Allows different implementations (Adjacency List, Matrix, etc.)
 *
 * Uses:
 * - Vertices represented as integers
 * - Edges represented through implementation (list, matrix, etc.)
 *
 * Methods:
 * - addVertex: adds a vertex to the graph
 * - addEdge: adds an edge between vertices
 * - getNeighbours: returns adjacent vertices
 * - size: returns number of vertices
 *
 * Design Benefits:
 * - Promotes abstraction and flexibility
 * - Allows interchangeable graph implementations
 *
 * Time Complexity:
 * - Depends on implementation
 */

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