## Minimum Spanning Tree (MST)

## A subset of edges that connects all vertices with minimum total weight (no cycles)

## Types / Algorithms
- Kruskal’s Algorithm (greedy + Union-Find)
- Prim’s Algorithm (greedy + priority queue)

### Time Complexities
Kruskal: O(E log E)

Prim:
- Using PQ: O(E log V)
- Using matrix: O(V²)

Union-Find (for Kruskal): ~O(1) amortized

## Common Patterns
- Greedy selection (pick smallest edge first)
- Cycle detection (Union-Find)
- Priority Queue (for minimum edge selection)
- Graph traversal with weights

## To use when:
- Connecting all nodes with minimum cost
- Network design (roads, cables, internet)
- Clustering problems
- Minimizing infrastructure cost

## Key Properties
- Works on **connected, weighted, undirected graphs**
- MST has exactly **V - 1 edges**
- No cycles allowed
- Multiple MSTs can exist (same total weight)

## Representations
- Edge List (for Kruskal)
- Adjacency List + Min Heap (for Prim)

## Algorithms Overview

### Kruskal’s Algorithm
1. Sort all edges by weight
2. Pick smallest edge
3. Add if it doesn’t form a cycle
4. Use Union-Find to detect cycles

### Prim’s Algorithm
1. Start from any node
2. Always pick smallest edge to a new node
3. Use Priority Queue
4. Grow tree step by step

## Graphics used:

#### Minimum Spanning Tree
![MST](/assets/mst.png)

![Kruskal](/assets/kruskal.png)

![Prim](/assets/prim.png)