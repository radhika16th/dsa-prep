/**
 * Implements Exponential Search on a sorted array.
 *
 * Idea:
 * - Quickly find a range where target may exist
 * - Then apply Binary Search in that range
 *
 * Steps:
 * 1. Check first element
 * 2. Increase index exponentially (1, 2, 4, 8, ...)
 * 3. Find range where target lies
 * 4. Perform Binary Search in that range
 *
 * Time Complexity:
 * - O(log n)
 *
 * Space Complexity:
 * - O(1)
 *
 * Requirement:
 * - Array must be SORTED
 */

public class ExponentialSearch {
    /**
     * Returns index of target, or -1 if not found
     */
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;

        // Check first element
        if (arr[0] == target)
            return 0;

        // Find range using exponential jumps
        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }

        // Apply binary search in found range
        return binarySearch(arr, i / 2, Math.min(i, n - 1), target);
    }

    /**
     * Standard Binary Search in a range
     */
    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            else if (arr[mid] < target)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

        int index = exponentialSearch(arr, 11);

        System.out.println("Index: " + index);
    }
}