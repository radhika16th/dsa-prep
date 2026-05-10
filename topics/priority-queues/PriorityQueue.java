import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implements a Generic Priority Queue using a heap.
 *
 * Idea:
 * - Uses a binary heap stored in an ArrayList
 * - Ordering is defined by a Comparator
 * - Default behavior depends on comparator:
 *     - (a, b) -> a - b  → Min Heap
 *     - (a, b) -> b - a  → Max Heap
 *
 * Index Relations:
 * - Parent = (i - 1) / 2
 * - Left child = 2*i + 1
 * - Right child = 2*i + 2
 *
 * Uses:
 * - heap: stores elements
 * - comp: defines priority ordering
 *
 * Operations:
 * - add: insert element
 * - poll: remove highest priority element
 * - peek: view highest priority element
 * - isEmpty: check if queue is empty
 *
 * Time Complexity:
 * - add: O(log n)
 * - poll: O(log n)
 * - peek: O(1)
 *
 * Space Complexity:
 * - O(n)
 */

public class PriorityQueue<T> {
    private List<T> heap; // Heap storage
    private Comparator<T> comp; // Comparator to define priority

    /**
     * Constructor with custom comparator
     */
    public PriorityQueue(Comparator<T> comp) {
        this.heap = new ArrayList<>();
        this.comp = comp;
    }

    /**
     * Adds an element to the queue
     */
    public void add(T val) {
        heap.add(val);
        heapifyUp(heap.size() - 1); // Restore heap property upwards
    }

    /**
     * Removes and returns highest priority element
     */
    public T poll() {
        if (heap.isEmpty())
            return null;

        T top = heap.get(0);
        T last = heap.remove(heap.size() - 1); // Remove last element

        // Fix heap if not empty
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return top;
    }

    /**
     * Returns the maximum element without removing it
     */
    public T peek() {
        if (heap.isEmpty())
            return null;
        
        return heap.get(0);
    }

    /**
     * Returns if heap is empty
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Moves element up to restore heap property
     */
    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1)/2;

            // If heap property satisfied, stop
            if (comp.compare(heap.get(i), heap.get(parent)) >= 0)
                break;
            
            swap(i, parent); // Swap with parent
            i = parent; // Move up
        }
    }

    /**
     * Moves element down to restore heap property
     */
    private void heapifyDown(int i) {
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // Check left child
        if (left < heap.size() && comp.compare(heap.get(left), heap.get(smallest)) < 0)
            smallest = left;

        // Check right child
        if (right < heap.size() && comp.compare(heap.get(right), heap.get(smallest)) < 0)
            smallest = right;

        // If a smaller child exists, swap and continue
        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    /**
     * Swaps two elements in the heap
     */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        // Min Heap
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b) -> a - b);

        minPQ.add(5);
        minPQ.add(1);
        minPQ.add(3);

        System.out.println("Min Heap:");
        while (!minPQ.isEmpty()) {
            System.out.println(minPQ.poll()); // 1, 3, 5
        }

        // Max Heap
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

        maxPQ.add(5);
        maxPQ.add(1);
        maxPQ.add(3);

        System.out.println("Max Heap:");
        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.poll()); // 5, 3, 1
        }
    }
}