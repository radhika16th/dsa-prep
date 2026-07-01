import java.util.*;

public class SCC {

    public static void findSCCs(AdjacencyListGraph graph) {

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        // Step 1: fill stack
        for (int v : graph.getVertices()) {
            if (!visited.contains(v)) {
                fillOrder(graph, v, visited, stack);
            }
        }

        // Step 2: reverse graph
        AdjacencyListGraph reversed = reverseGraph(graph);

        // Step 3: process stack
        visited.clear();

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                dfs(reversed, node, visited);
                System.out.println(); // one SCC
            }
        }
    }

    private static void fillOrder(AdjacencyListGraph graph, int node,
                                 Set<Integer> visited, Stack<Integer> stack) {

        visited.add(node);

        for (int neighbor : graph.getNeighbours(node)) {
            if (!visited.contains(neighbor)) {
                fillOrder(graph, neighbor, visited, stack);
            }
        }

        stack.push(node);
    }

    private static AdjacencyListGraph reverseGraph(AdjacencyListGraph graph) {

        AdjacencyListGraph reversed = new AdjacencyListGraph();

        for (int v : graph.getVertices()) {
            for (int neighbor : graph.getNeighbours(v)) {
                reversed.addEdge(neighbor, v); // reverse edge
            }
        }

        return reversed;
    }

    private static void dfs(AdjacencyListGraph graph, int node, Set<Integer> visited) {

        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getNeighbours(node)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}