## Searching

## Finding a target element in a data structure

## Types
- Linear Search (unsorted data)
- Binary Search (sorted data)
- DFS / BFS (graphs & trees)
- Hash-based Search (maps/sets)
- Tree Search (BST)

### Time Complexities
Linear Search: O(n)

Binary Search: O(log n)

BFS / DFS: O(V + E)

HashMap Search: O(1) (average)

BST Search: O(log n) (balanced), O(n) (worst)

## Common Patterns
- Two Pointers (sorted arrays)
- Binary Search Variations
- Sliding Window
- Fast Lookup (HashMap / Set)
- Graph Traversal (BFS / DFS)

## To use when:
- Looking for an element in a list/array
- Searching efficiently in sorted data
- Finding shortest path (BFS)
- Exploring all possibilities (DFS)
- Fast lookup needed (HashMap)
- Searching ordered structure (BST)

## Key Ideas:
- Linear Search: Check every element one by one
- Binary Search: Divide array in half repeatedly; works ONLY on sorted data
- BFS (Breadth First Search): Explores level by level; finds shortest path in unweighted graphs
- DFS (Depth First Search): Goes deep before backtracking; used for traversal, cycles, components
- HashMap Search: Store → lookup instantly; used in problems like Two Sum
- BST Search: Left = smaller, Right = bigger; skip half of tree each step

## When to Choose What
- Unsorted → Linear Search  
- Sorted → Binary Search  
- Graph shortest path → BFS  
- Explore all paths → DFS  
- Fast lookup → HashMap  
- Ordered tree → BST  