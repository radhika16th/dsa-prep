import java.util.*;

/**
 * Implements Depth-First Search (DFS) using a simple adjacency list.
 *
 * Idea:
 * - Explore as deep as possible before backtracking
 * - Works directly with Map<Integer, List<Integer>>
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V)
 */

public class DFS {
    /**
     * Recursive DFS
     */
    public static void dfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(graph, start, visited);
    }

    private static void dfsHelper(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        // If already visited, stop
        if (visited.contains(node))
            return;

        // Mark visited
        visited.add(node);

        // Process node
        System.out.print(node + " ");

        // Visit neighbors
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            dfsHelper(graph, neighbor, visited);
        }
    }

    /**
     * Iterative DFS using stack
     */
    public static void dfsIterative(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {

            int node = stack.pop();

            if (visited.contains(node))
                continue;

            visited.add(node);
            System.out.print(node + " ");

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, new ArrayList<>());
        graph.put(4, new ArrayList<>());

        System.out.println("Recursive DFS:");
        dfs(graph, 0); // Example: 0 1 3 2 4

        System.out.println("\nIterative DFS:");
        dfsIterative(graph, 0);
    }
}