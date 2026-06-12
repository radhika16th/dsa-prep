import java.util.Arrays;

/**
 * Heap Sort
 *
 * Idea:
 * 1. Build a Max Heap from the array.
 * 2. The largest element will be at the root.
 * 3. Swap the root with the last element.
 * 4. Reduce heap size.
 * 5. Heapify again.
 * 6. Repeat until sorted.
 *
 * Max Heap Property:
 *
 * Parent >= Children
 *
 * Example:
 *
 *         50
 *       /    \
 *      30     40
 *     /  \
 *   10   20
 *
 * Time Complexity:
 * Best Case    : O(n log n)
 * Average Case : O(n log n)
 * Worst Case   : O(n log n)
 *
 * Space Complexity:
 * O(1)
 *
 * Not Stable
 * 
 * Why is Heap Sort always O(n log n)?
 * 
 * Because:
 * 1. Building the heap = O(n)
 * 2. We perform n extractions.
 * 3. Each extraction requires a heapify = O(log n)
 * 
 * O(n) + O(n log n) = O(n log n)
 */

public class Heap {
    /**
     * Sorts the array using Heap Sort.
     */
    public void heapSort(int[] arr) {
        int n = arr.length;

        /*
         * Start from last non-leaf node and move upward.
         * Last non-leaf node: n/2 - 1
         */
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i);

        /*
         * Root always contains the largest element.
         * Move it to the end.
         */
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // Move largest element to end
            heapify(arr, i, 0); // Restore heap property for remaining elements. Heap size becomes i.
        }
    }

    /**
     * Restores the Max Heap property.
     *
     * Parameters:
     * arr = array
     * n = heap size
     * i = current root
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i;  // Assume current node is largest

        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2; // Right child index

        // Check left child
        if (left < n && arr[left] > arr[largest])
            largest = left;
        
        // Check right child
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If a child is larger, swap and continue heapifying.
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest); // Recursively fix affected subtree.
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * Example:
     *
     * Before:
     * [64, 25]
     *
     * After:
     * [25, 64]
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        Heap ss = new Heap();
        ss.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}