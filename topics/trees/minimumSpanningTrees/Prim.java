import java.util.*;

/**
 * Implements Prim’s Algorithm to find Minimum Spanning Tree (MST).
 *
 * Idea:
 * - Start from any node
 * - Always pick the smallest edge connecting to a new node
 * - Grow the MST step by step
 *
 * Uses:
 * - graph: adjacency list (node → [neighbor, weight])
 * - visited: tracks nodes already in MST
 * - pq: min-heap storing (node, weight)
 *
 * Time Complexity:
 * - O(E log V)
 *
 * Space Complexity:
 * - O(V)
 */

public class Prim {

    /**
     * Returns total weight of MST
     */
    public static int primMST(Map<Integer, List<int[]>> graph, int start) {
        Set<Integer> visited = new HashSet<>(); // Track visited nodes
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // Min heap: [node, weight]

        pq.add(new int[]{start, 0}); // Start from initial node

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            if (visited.contains(node)) continue; // Skip if already included

            // Add node to MST
            visited.add(node);
            totalWeight += weight;

            // Explore neighbors
            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int next = neighbor[0];
                int w = neighbor[1];

                // Add edge if node not visited
                if (!visited.contains(next)) {
                    pq.add(new int[]{next, w});
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Undirected weighted graph (add both directions)
        graph.put(0, Arrays.asList(new int[]{1, 4}, new int[]{2, 1}));
        graph.put(1, Arrays.asList(new int[]{0, 4}, new int[]{2, 2}, new int[]{3, 5}));
        graph.put(2, Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{3, 8}));
        graph.put(3, Arrays.asList(new int[]{1, 5}, new int[]{2, 8}));

        int mstWeight = primMST(graph, 0);

        System.out.println("Total MST Weight: " + mstWeight);
    }

}