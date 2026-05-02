/**
 * Implements a Queue using a singly linked list.
 * Follows FIFO (First In, First Out) principle.
 *
 * Idea:
 * - Uses nodes where each node points to the next
 * - front points to the first element
 * - rear points to the last element
 *
 * Uses:
 * - front: first node (dequeue from here)
 * - rear: last node (enqueue here)
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

public class QueueLinkedList {
    QueueListNode front, rear; // Front and rear pointers

    /**
     * Adds an element to the rear of the queue
     */
    public void enqueue(int x) {
        QueueListNode newNode = new QueueListNode(x);

        // If queue is empty, front and rear both point to new node
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        // Link new node at the end and move rear
        rear.next = newNode;
        rear = newNode;
    }

    /**
     * Removes and returns the front element
     */
    public int dequeue() {
        // If queue is empty
        if (front == null)
            return -1;

        int val = front.value; // Store value to return
        front = front.next; // Move front to next node

        // If queue becomes empty, reset rear as well
        if (front == null)
            rear = null;
        
        return val;
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();

        // Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // Dequeue and print
        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20

        // Add more elements
        q.enqueue(40);
        q.enqueue(50);

        // Dequeue remaining elements
        System.out.println(q.dequeue()); // 30
        System.out.println(q.dequeue()); // 40
        System.out.println(q.dequeue()); // 50
    }
}