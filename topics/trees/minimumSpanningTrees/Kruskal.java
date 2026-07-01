import java.util.*;

/**
 * Implements Union-Find (Disjoint Set).
 *
 * Idea:
 * - Track connected components
 * - Use path compression for fast lookup
 *
 * Time Complexity:
 * - find: ~O(1) amortized
 * - union: ~O(1) amortized
 */
class UnionFind {
    int[] parent;

    /**
     * Initialize each node as its own parent
     */
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    /**
     * Finds root with path compression
     */
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    /**
     * Unions two sets, returns false if already connected
     */
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        // Already connected → would form cycle
        if (px == py) return false;

        // Merge sets
        parent[px] = py;
        return true;
    }
}

/**
 * Implements Kruskal’s Algorithm for MST.
 *
 * Idea:
 * - Sort edges by weight
 * - Add smallest edge if it doesn’t form a cycle
 * - Use Union-Find to detect cycles
 *
 * Uses:
 * - edges: list of (u, v, weight)
 * - UnionFind: track connected components
 *
 * Time Complexity:
 * - O(E log E)
 *
 * Space Complexity:
 * - O(V)
 */
public class Kruskal {
    /**
     * Returns total weight of MST
     */
    public static int kruskalMST(int n, List<int[]> edges) {

        // sort edges by weight
        edges.sort((a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int totalWeight = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            // add edge if no cycle
            if (uf.union(u, v)) {
                totalWeight += w;
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {

        int n = 4; // number of vertices

        List<int[]> edges = new ArrayList<>();

        // edges: {u, v, weight}
        edges.add(new int[]{0, 1, 4});
        edges.add(new int[]{0, 2, 1});
        edges.add(new int[]{1, 2, 2});
        edges.add(new int[]{1, 3, 5});
        edges.add(new int[]{2, 3, 8});

        int mstWeight = kruskalMST(n, edges);

        System.out.println("Total MST Weight: " + mstWeight);
    }
}