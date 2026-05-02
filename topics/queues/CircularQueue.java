/**
 * Implements a Circular Queue using an array.
 * Follows FIFO (First In, First Out) principle.
 *
 * Idea:
 * - Uses a fixed-size array with circular indexing
 * - rear moves forward for enqueue
 * - front moves forward for dequeue
 * - wraps around using modulo (%)
 *
 * Uses:
 * - arr: stores queue elements
 * - front: index of current front element
 * - rear: index where next element will be inserted
 * - size: number of elements in queue
 * - capacity: maximum size
 *
 * Operations:
 * - enqueue: insert at rear
 * - dequeue: remove from front
 *
 * Time Complexity:
 * - enqueue: O(1)
 * - dequeue: O(1)
 *
 * Space Complexity:
 * - O(n)
 */

public class CircularQueue {
    int[] arr;
    int front, rear, size, capacity;

    /**
     * Constructor to initialize queue
     */
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity]; 
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * Adds an element to the queue
     * @return true if successful, false if full
     */
    public boolean enqueue(int x) {
        // Check if full
        if (size == capacity)
            return false;

        arr[rear] = x; // Insert at rear
        rear = (rear + 1) % capacity; // Move rear circularly
        size++;
        return true;
    }

    /**
     * Removes and returns front element
     */
    public int dequeue() {
        // Check if empty
        if (size == 0)
            return -1;
        
        int val = arr[front]; // Get value
        front = (front + 1) % capacity; // Move front circularly
        size--;
        return val;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        // Enqueue elements
        System.out.println(q.enqueue(10)); // true
        System.out.println(q.enqueue(20)); // true
        System.out.println(q.enqueue(30)); // true

        // Dequeue
        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20

        // Add more (tests wrap-around)
        System.out.println(q.enqueue(40)); // true
        System.out.println(q.enqueue(50)); // true
        System.out.println(q.enqueue(60)); // true

        // Dequeue all
        System.out.println(q.dequeue()); // 30
        System.out.println(q.dequeue()); // 40
        System.out.println(q.dequeue()); // 50
        System.out.println(q.dequeue()); // 60
    }
}