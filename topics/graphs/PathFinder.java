import java.util.*;

public class PathFinder {
    public static List<Integer> getPath(AdjacencyListGraph graph, int start, int end) {

        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

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

        // rebuild path
        List<Integer> path = new ArrayList<>();
        int curr = end;

        while (curr != start) {
            path.add(curr);
            curr = parent.get(curr);
        }

        path.add(start);
        Collections.reverse(path);

        return path;
    }
}