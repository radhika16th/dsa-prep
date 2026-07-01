import java.util.*;

/**
 * Finds Strongly Connected Components (SCCs) using Kosaraju’s Algorithm.
 *
 * Idea:
 * - A strongly connected component is a group of nodes where
 *   every node is reachable from every other node
 *
 * Steps:
 * 1. Run DFS and push nodes to stack (based on finish time)
 * 2. Reverse the graph
 * 3. Process nodes from stack using DFS on reversed graph
 *
 * Uses:
 * - stack: stores nodes by finishing order
 * - visited: tracks visited nodes
 * - reversed graph: edges reversed for second DFS
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V)
 */

public class SCC {

    /**
     * Finds and prints all SCCs
     */
    public static void findSCCs(AdjacencyListGraph graph) {

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        // Step 1: Fill stack with nodes based on finish time
        for (int v : graph.getVertices()) {
            if (!visited.contains(v)) {
                fillOrder(graph, v, visited, stack);
            }
        }

        // Step 2: reverse graph
        AdjacencyListGraph reversed = reverseGraph(graph);

        // Step 3: Process nodes in order defined by stack
        visited.clear();

        while (!stack.isEmpty()) {
            int node = stack.pop();

            // If not visited, this forms a new SCC
            if (!visited.contains(node)) {
                dfs(reversed, node, visited);
                System.out.println();  // end of one SCC
            }
        }
    }

    /**
     * DFS to fill stack based on finishing time
     */
    private static void fillOrder(AdjacencyListGraph graph, int node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node);

        for (int neighbor : graph.getNeighbours(node)) {
            if (!visited.contains(neighbor)) {
                fillOrder(graph, neighbor, visited, stack);
            }
        }

        stack.push(node); // Push AFTER visiting all neighbors
    }

    /**
     * Reverses all edges in the graph
     */
    private static AdjacencyListGraph reverseGraph(AdjacencyListGraph graph) {
        AdjacencyListGraph reversed = new AdjacencyListGraph();

        for (int v : graph.getVertices()) {
            for (int neighbor : graph.getNeighbours(v)) {
                reversed.addEdge(neighbor, v); // Reverse edge direction
            }
        }

        return reversed;
    }

    /**
     * DFS to print one SCC
     */
    private static void dfs(AdjacencyListGraph graph, int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getNeighbours(node)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyListGraph g = new AdjacencyListGraph();

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // SCC 1

        g.addEdge(1, 3);
        g.addEdge(3, 4); // SCC 2

        System.out.println("Strongly Connected Components:");
        findSCCs(g);
    }
}