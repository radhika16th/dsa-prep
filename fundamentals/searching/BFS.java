import java.util.*;

/**
 * Implements Breadth-First Search (BFS) using a simple adjacency list.
 *
 * Idea:
 * - Traverse graph level by level
 * - Visit all neighbors before going deeper
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V)
 */

public class BFS {
    /**
     * BFS traversal starting from a node
     */
    public static void bfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // Initialize
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Process node
            System.out.print(node + " ");

            // Visit neighbors
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
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

        System.out.println("BFS:");
        bfs(graph, 0);
    }
}