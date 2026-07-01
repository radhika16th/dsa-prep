import java.util.*;

/**
 * Implements Topological Sort using DFS.
 *
 * Idea:
 * - Works only for Directed Acyclic Graphs (DAG)
 * - Use DFS to explore nodes
 * - Add node to stack AFTER visiting all neighbors
 * - Reverse stack gives topological order
 *
 * Uses:
 * - graph: adjacency list representation
 * - visited: tracks visited nodes
 * - stack: stores nodes in reverse topological order
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V)
 */

public class Topological {

    /**
     * Returns topological ordering of the graph
     */
    public static List<Integer> topoSort(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>(); // Track visited nodes
        Stack<Integer> stack = new Stack<>(); // Stack to store order

        // Run DFS on all nodes
        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(graph, node, visited, stack);
            }
        }

        // Build result from stack
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    /**
     * DFS helper function
     */
    private static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node); // Mark current node as visited

        // Visit all neighbors
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, stack);
            }
        }
        
        // Add node AFTER visiting neighbors (this ensures correct ordering)
        stack.push(node);
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, new ArrayList<>());

        List<Integer> order = Topological.topoSort(graph);

        System.out.println(order);
    }
}