import java.util.Arrays;

/**
 * Implements Heap Sort (In-Place)
 *
 * Idea:
 * - Convert array into a Max Heap
 * - Repeatedly swap root (max) with last element
 * - Reduce heap size and restore heap property
 *
 * Steps:
 * 1. Build Max Heap from array
 * 2. Swap root with last element
 * 3. Reduce heap size
 * 4. Heapify root
 *
 * Time Complexity:
 * - O(n log n)
 *
 * Space Complexity:
 * - O(1) (in-place, no extra memory)
 */

public class HeapSort {
    /**
     * Sorts the array using Heap Sort
     */
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            downheap(arr, n, i);
        }

        // Extract elements from heap
        while (n > 0) {
            swap(arr, 0, n - 1); // Move current max (root) to end
            n--;
            downheap(arr, n, 0); // Restore heap property
        }
    }

    /**
     * Restores heap property (Max Heap)
     */
    private void downheap(int[] arr, int n, int i) {
        int largest = i;

        int left = 2*i + 1;
        int right = 2*i + 2;

        // Compare left child
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Compare right child
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root, swap and continue
        if (largest != i) {
            swap(arr, i, largest);
            downheap(arr, n, largest);
        }
    }

    /**
     * Swaps two elements in array
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        HeapSort hs = new HeapSort();
        hs.heapSort(arr);

        System.out.println(Arrays.toString(arr)); // Output: [1, 3, 4, 5, 10]
    }
}