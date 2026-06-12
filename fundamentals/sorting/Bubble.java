import java.util.Arrays;

/**
 * Bubble Sort
 *
 * Idea:
 * Repeatedly compare adjacent elements.
 * If they are in the wrong order, swap them.
 *
 * Larger values "bubble" toward the end of the array
 * after each pass.
 *
 * Example:
 *
 * [5, 3, 8, 1]
 *
 * Compare 5 and 3 -> swap
 * [3, 5, 8, 1]
 *
 * Compare 5 and 8 -> no swap
 * [3, 5, 8, 1]
 *
 * Compare 8 and 1 -> swap
 * [3, 5, 1, 8]
 *
 * Notice:
 * The largest value (8) bubbled to the end.
 *
 * Time Complexity:
 * Best Case    : O(n)
 *      - Already sorted
 *      - No swaps occur
 *      - Stops early using swapped flag
 *
 * Average Case : O(n²)
 *
 * Worst Case   : O(n²)
 *      - Reverse sorted array
 *
 * Space Complexity:
 * O(1)
 *
 * Stable:
 * Yes
 */

public class Bubble {
    /**
     * Sorts an array in ascending order using Bubble Sort.
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length; // Length of array

        // Outer loop controls the number of passes.
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false; // Tracks whether any swaps happened.
            
            /*
             * Compare adjacent elements.
             *
             * Notice:
             * n - i - 1
             *
             * We don't need to check the last i elements
             * because they are already sorted.
             */
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) { // If left element is larger, swap them.
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }

            // If no swaps occurred, array is already sorted. Stop early.
            if (!swapped)
                break;
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

        Bubble ss = new Bubble();
        ss.bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}