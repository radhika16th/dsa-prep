import java.util.*;

/**
 * Implements Depth-First Search (DFS) on a graph.
 *
 * Idea:
 * - Explore as deep as possible before backtracking
 * - Uses recursion (implicit stack)
 *
 * Uses:
 * - graph: adjacency list graph
 * - visited: tracks visited nodes
 *
 * Applications:
 * - Path finding
 * - Cycle detection
 * - Topological sort
 * - Connected components
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V) (recursion stack + visited set)
 */

public class DFS {
    /**
     * Public method to start DFS
     */
    public static void dfs(AdjacencyListGraph graph, int start) {
        Set<Integer> visited = new HashSet<>();
        dfs(graph, start, visited);
    }

    /**
     * Recursive DFS helper
     */
    private static void dfs(AdjacencyListGraph graph, int node, Set<Integer> visited) {
        if (visited.contains(node)) return; // If already visited, stop

        visited.add(node); // Mark visited
        System.out.print(node + " "); // Process node

        // Visit neighbors
        for (int neighbor : graph.getNeighbours(node)) {
            dfs(graph, neighbor, visited);
        }
    }
}