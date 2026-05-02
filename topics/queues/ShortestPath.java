/**
 * Implements Breadth-First Search (BFS) using a queue.
 *
 * Idea:
 * - Start from a source node
 * - Visit all its neighbors first before going deeper
 * - Uses a queue to process nodes level by level
 *
 * Uses:
 * - graph: adjacency list representation of graph
 * - visited: tracks visited nodes to avoid cycles
 * - QueueArray: custom queue for BFS traversal
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

import java.util.ArrayList;
import java.util.List;

public class ShortestPath {

    /**
     * Performs BFS traversal starting from a given node
     */
    public static void bfs(int start, List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];  // Track visited nodes
        QueueArray q = new QueueArray(n); // Create queue with capacity n

        // Start BFS
        q.enqueue(start);
        visited[start] = true;

        // Continue until queue becomes empty
        while (true) { 
            int node = q.dequeue(); // Remove front node

            // If queue is empty, stop
            if (node == -1)
                break;

            System.out.print(node + " ");

            // Visit all neighbors
            for (int neighbour : graph.get(node)) {
                // If not visited, add to queue
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.enqueue(neighbour);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) 
            graph.add(new ArrayList<>());

        // Example graph
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        bfs(0, graph, n); // Output: 0 1 2 3 4
    }
}