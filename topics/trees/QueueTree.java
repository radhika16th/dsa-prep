/**
 * Implements a Queue for TreeNodes using a circular array.
 * Follows FIFO (First In, First Out) principle.
 *
 * Idea:
 * - Stores TreeNode objects instead of integers
 * - Uses circular indexing to efficiently reuse space
 *
 * Uses:
 * - arr: stores TreeNode elements
 * - front: index of the front node
 * - rear: index of the last node
 * - size: current number of elements
 * - capacity: maximum size of queue
 *
 * Operations:
 * - enqueue: insert TreeNode at rear
 * - dequeue: remove TreeNode from front
 *
 * Applications:
 * - Level-order traversal (BFS) in trees
 * - Tree-based algorithms
 *
 * Time Complexity:
 * - enqueue: O(1)
 * - dequeue: O(1)
 *
 * Space Complexity:
 * - O(n)
 */

public class QueueTree {
    private TreeNode[] arr; // Array to store TreeNodes
    private int front, rear, size, capacity; // Queue pointers and metadata

    /**
     * Constructor to initialize queue with given capacity
     */
    public QueueTree(int capacity) {
        this.capacity = capacity;
        arr = new TreeNode[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Adds a TreeNode to the rear of the queue
     */
    public void enqueue(TreeNode node) {
        // Check if queue is full
        if (size == capacity)
            return;

        rear = (rear + 1) % capacity; // Move rear circularly
        arr[rear] = node; // Insert node
        size++;
    }

    /**
     * Removes and returns the front TreeNode
     */
    public TreeNode dequeue() {
        // Check if queue is empty
        if (size == 0)
            return null;
        
        TreeNode node = arr[front]; // Get front node
        front = (front + 1) % capacity; // Move front circularly
        size--;
        return node;
    }
}