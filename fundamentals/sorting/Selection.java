import java.util.Arrays;

/**
 * Selection Sort
 *
 * Idea:
 * Repeatedly find the smallest element from the unsorted
 * portion of the array and place it at the beginning.
 *
 * Think of it like:
 *
 * [64, 25, 12, 22, 11]
 *
 * Find smallest (11)
 * Put it in position 0
 *
 * [11, 25, 12, 22, 64]
 *
 * Then find smallest from remaining elements
 * and put it in position 1.
 *
 * Time Complexity:
 * Best Case    : O(n²)
 * Average Case : O(n²)
 * Worst Case   : O(n²)
 *
 * Unlike Insertion Sort, Selection Sort always
 * scans the remaining array even if it is already sorted.
 *
 * Space Complexity:
 * O(1)
 *
 * In-place sorting algorithm.
 */

public class Selection {
    /**
     * Sorts an array in ascending order
     * using Selection Sort.
     */
    public void selectionSort(int[] arr) {
        int n = arr.length; // Length of array

        // Outer loop controls where the next smallest element should be placed.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the current position contains the smallest value.

            // Search the remaining unsorted portion for a smaller value.
            for (int j = i + 1; j < n; j++) {
                // If a smaller value is found, update minIndex.
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            // Put the smallest value found into its correct sorted position.
            swap(arr, i, minIndex);
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

        Selection ss = new Selection();
        ss.selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}