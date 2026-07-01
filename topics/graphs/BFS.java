import java.util.*;

/**
 * Implements Breadth-First Search (BFS) on a graph.
 *
 * Idea:
 * - Traverse graph level by level
 * - Visit all neighbors before going deeper
 * - Uses a queue to maintain order
 *
 * Uses:
 * - graph: adjacency list graph
 * - visited: tracks visited nodes
 * - queue: processes nodes in FIFO order
 *
 * Applications:
 * - Shortest path in unweighted graphs
 * - Level-order traversal
 * - Connectivity checking
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V)
 */

public class BFS {
    /**
     * Performs BFS traversal starting from a node
     */
    public static void bfs(AdjacencyListGraph graph, int start) {
        Set<Integer> visited = new HashSet<>(); // Track visited nodes
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS

        q.add(start); // Start node
        visited.add(start);

        while (!q.isEmpty()) {
            int node = q.poll(); // Remove front node
            System.out.print(node + " "); // Process node

            // Visit neighbors
            for (int neighbor : graph.getNeighbours(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
    }
}