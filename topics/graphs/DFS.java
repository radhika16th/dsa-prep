import java.util.*;

public class DFS {
    public static void dfs(AdjacencyListGraph graph, int start) {
        Set<Integer> visited = new HashSet<>();
        dfs(graph, start, visited);
    }

    private static void dfs(AdjacencyListGraph graph, int node, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getNeighbours(node)) {
            dfs(graph, neighbor, visited);
        }
    }
}