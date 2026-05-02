/**
 * Implements a Queue using a circular array.
 * Follows FIFO (First In, First Out) principle.
 *
 * Idea:
 * - Uses a fixed-size array with circular indexing
 * - When rear reaches end, it wraps around using modulo
 *
 * Uses:
 * - arr: stores queue elements
 * - front: index of the front element
 * - rear: index of the last element
 * - size: current number of elements
 * - capacity: maximum size of queue
 *
 * Operations:
 * - enqueue: insert element at rear
 * - dequeue: remove element from front
 *
 * Time Complexity:
 * - enqueue: O(1)
 * - dequeue: O(1)
 *
 * Space Complexity:
 * - O(n)
 */

public class QueueArray {
    // Array to store queue elements
    private static int[] arr; 

    // Points to the front, rear elements, stores current number of elements, maximum capacity in queue
    private static int front, rear, size, capacity;

    /**
     * Default constructor with capacity = 10
     */
    public QueueArray() {
        this.capacity = 10;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Constructor with custom capacity
     */
    public QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Adds an element to the rear of the queue
     */
    public void enqueue(int x) {
        // Check if queue is full
        if (size == capacity)  
            return;

        rear = (rear + 1) % capacity; // Move rear in circular manner
        arr[rear] = x; // Insert element
        size++; // Increase size
    }

    /**
     * Removes and returns the front element
     */
    public int dequeue() {
        // Check if queue is empty
        if (size == 0)
            return -1;
        
        int val = arr[front]; // Get front value
        front = (front + 1) % capacity; // Move front forward circularly
        size--; // Decrease size
        return val;
    }

    public static void main(String[] args) {
        // Create queue with capacity 5
        QueueArray q = new QueueArray(5);

        // Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // Dequeue and print
        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20

        // Add more elements (tests circular behavior)
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);

        // Dequeue remaining elements
        System.out.println(q.dequeue()); // 30
        System.out.println(q.dequeue()); // 40
        System.out.println(q.dequeue()); // 50
        System.out.println(q.dequeue()); // 60
    }
}