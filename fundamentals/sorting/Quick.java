import java.util.Arrays;

/**
 * Quick Sort Algorithm
 *
 * Idea:
 * - Pick a pivot
 * - Put all smaller elements on left
 * - Put all larger elements on right
 * - Recursively sort both sides
 *
 * Time Complexity:
 * - Average: O(n log n)
 * - Worst: O(n^2)
 *
 * Space Complexity:
 * - O(log n) (recursion stack)
 */


public class Quick {
    /**
     * Main quicksort function
     */
    public void quickSort(int[] arr, int low, int high) {
        // Base case: 1 element or invalid range
        if (low >= high) return;

        int pivotIndex = partition(arr, low, high); // Place pivot in correct position
        quickSort(arr, low, pivotIndex-1); // Sort left side
        quickSort(arr, pivotIndex+1, high); // Sort right side
    }

    /**
     * Partition function
     * - Picks last element as pivot
     * - Places it in correct sorted position
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1; // pointer for smaller elements

        // Traverse and rearrange elements
        for (int j = low; j < high; j++) {
            // If current element < pivot → move to left side
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Place pivot in correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        Quick qs = new Quick();
        qs.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}