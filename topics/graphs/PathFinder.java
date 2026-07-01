import java.util.*;

/**
 * Finds shortest path between two nodes in an unweighted graph.
 *
 * Idea:
 * - Use BFS to explore graph level by level
 * - Track parent of each node
 * - Reconstruct path from end → start
 *
 * Uses:
 * - graph: adjacency list graph
 * - visited: tracks visited nodes
 * - parent: stores previous node for path reconstruction
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V)
 */

public class PathFinder {
    /**
     * Returns shortest path from start to end
     */
    public static List<Integer> getPath(AdjacencyListGraph graph, int start, int end) {

        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Initialise BFS
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();

            // found destination
            if (node == end) break;

            for (int neighbor : graph.getNeighbours(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, node); // store path
                    q.add(neighbor);
                }
            }
        }

        // If end not reached → no path
        if (!visited.contains(end))
            return new ArrayList<>();

        // Reconstruct path from end → start
        List<Integer> path = new ArrayList<>();
        int curr = end;

        while (curr != start) {
            path.add(curr);
            curr = parent.get(curr);
        }

        path.add(start);
        Collections.reverse(path); // Reconstruct path from end → start

        return path;
    }

    public static void main(String[] args) {

        AdjacencyListGraph graph = new AdjacencyListGraph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);

        List<Integer> path = getPath(graph, 0, 3);

        System.out.println("Path: " + path);
    }
}