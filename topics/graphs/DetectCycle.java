import java.util.*;

/**
 * Detects cycle in a Directed Graph using DFS.
 *
 * Idea:
 * - Use DFS traversal
 * - Track:
 *     - visited: nodes already processed
 *     - recStack: nodes in current recursion path
 *
 * Key Insight:
 * - If we revisit a node already in recStack → cycle exists
 *
 * Uses:
 * - graph: adjacency list graph
 * - visited: tracks visited nodes
 * - recStack: tracks current DFS path
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V)
 */

public class DetectCycle {

    /**
     * Returns true if graph contains a cycle
     */
    public static boolean hasCycle(AdjacencyListGraph graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        // Check all components
        for (int node : graph.getVertices()) {
            if (dfs(graph, node, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    /**
     * DFS helper function
     */
    private static boolean dfs(AdjacencyListGraph graph, int node, Set<Integer> visited, Set<Integer> recStack) {

        if (recStack.contains(node)) return true; // If node is in recursion stack → cycle found
        if (visited.contains(node)) return false; // If already processed → no cycle from here

        // Mark node as visited and add to recursion stack
        visited.add(node);
        recStack.add(node);

        // Visit all neighbors
        for (int neighbor : graph.getNeighbours(node)) {
            if (dfs(graph, neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(node); // Remove node from recursion stack after processing
        return false;
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();

        // Create graph with cycle
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // cycle here

        System.out.println("Has Cycle: " + hasCycle(graph)); // true
    }
}