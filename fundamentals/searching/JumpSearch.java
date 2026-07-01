/**
 * Implements Jump Search on a sorted array.
 *
 * Idea:
 * - Jump ahead by fixed block size
 * - Once target block is found, do linear search
 *
 * Steps:
 * 1. Choose block size = √n
 * 2. Jump in steps until element ≥ target
 * 3. Perform linear search in that block
 *
 * Time Complexity:
 * - O(√n)
 *
 * Space Complexity:
 * - O(1)
 *
 * Requirement:
 * - Array must be SORTED
 */

public class JumpSearch {
    /**
     * Returns index of target, or -1 if not found
     */
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;

        // Step size = sqrt(n)
        int step = (int) Math.sqrt(n);

        int prev = 0;

        // Jump in blocks
        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);

            // If we exceed array size
            if (prev >= n)
                return -1;
        }

        // Linear search in block
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

        int index = jumpSearch(arr, 9);

        System.out.println("Index: " + index);
    }
}