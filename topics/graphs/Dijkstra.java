import java.util.*;

/**
 * Implements Dijkstra’s Algorithm for shortest path.
 *
 * Idea:
 * - Works on weighted graphs with non-negative weights
 * - Use a min-heap (priority queue) to always expand the closest node
 *
 * Uses:
 * - graph: adjacency list where each node maps to (neighbor, weight)
 * - dist: stores shortest distance from source
 * - pq: min-heap storing (node, distance)
 *
 * Time Complexity:
 * - O((V + E) log V)
 *
 * Space Complexity:
 * - O(V)
 */

public class Dijkstra {

    /**
     * Returns shortest distances from start node
     */
    public static Map<Integer, Integer> shortestPath(Map<Integer, List<int[]>> graph, int start) {
        Map<Integer, Integer> dist = new HashMap<>(); // Distance map
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // Min heap: [node, distance]

        // Initialize
        pq.add(new int[]{start, 0});
        dist.put(start, 0);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            // Skip outdated entries
            if (d > dist.get(node)) continue;

            // Traverse neighbors (safe get)
            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];

                int newDist = d + weight;

                // Relaxation step
                if (!dist.containsKey(next) || newDist < dist.get(next)) {
                    dist.put(next, newDist);
                    pq.add(new int[]{next, newDist});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Build weighted graph
        graph.put(0, Arrays.asList(new int[]{1, 4}, new int[]{2, 1}));
        graph.put(1, Arrays.asList(new int[]{3, 1}));
        graph.put(2, Arrays.asList(new int[]{1, 2}, new int[]{3, 5}));
        graph.put(3, new ArrayList<>());

        Map<Integer, Integer> result = shortestPath(graph, 0);

        System.out.println("Shortest distances from 0:");
        for (int node : result.keySet()) {
            System.out.println(node + " -> " + result.get(node));
        }
    }
}