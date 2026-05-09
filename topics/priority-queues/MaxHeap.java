import java.util.ArrayList;
import java.util.List;

/**
 * Implements a Max Heap using an ArrayList.
 *
 * Idea:
 * - Complete binary tree stored in an array
 * - Parent is always greater than children
 * - Largest element is always at index 0
 *
 * Index Relations:
 * - Parent = (i - 1) / 2
 * - Left child = 2*i + 1
 * - Right child = 2*i + 2
 *
 * Uses:
 * - heap: dynamic array storing heap elements
 *
 * Operations:
 * - insert: add element and fix heap upwards
 * - extractMax: remove largest element and fix heap downwards
 * - peek: view largest element
 * - isEmpty: check if heap is empty
 *
 * Time Complexity:
 * - insert: O(log n)
 * - extractMax: O(log n)
 * - peek: O(1)
 *
 * Space Complexity:
 * - O(n)
 */

public class MaxHeap {
    private List<Integer> heap; // List to store heap elements

    /**
     * Constructor initializes empty heap
     */
    public MaxHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Inserts a value into the heap
     */
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1); // Restore heap property upwards
    }

    /**
     * Removes and returns the maximum element (root)
     */
    public int extractMax() {
        // If heap is empty
        if (heap.isEmpty())
            return -1;

        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1); // Remove last element

        // If heap still has elements, move last to root and fix
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }

    /**
     * Returns the maximum element without removing it
     */
    public int peek() {
        if (heap.isEmpty())
            return -1;
        
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
            if (heap.get(i) <= heap.get(parent))
                break;
            
            swap(i, parent); // Swap with parent
            i = parent; // Move up
        }
    }

    /**
     * Moves element down to restore heap property
     */
    private void heapifyDown(int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // Check left child
        if (left < heap.size() && heap.get(left) > heap.get(largest))
            largest = left;

        // Check right child
        if (right < heap.size() && heap.get(right) > heap.get(largest))
            largest = right;

        // If a smaller child exists, swap and continue
        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    /**
     * Swaps two elements in the heap
     */
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();

        mh.insert(5);
        mh.insert(2);
        mh.insert(8);
        mh.insert(1);

        System.out.println("Max: " + mh.peek()); // Peek Max

        while (!mh.isEmpty()) {
            System.out.println(mh.extractMax());
        }
    }
}