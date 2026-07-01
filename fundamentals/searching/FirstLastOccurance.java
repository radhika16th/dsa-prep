/**
 * Finds the First and Last Occurrence of a target in a sorted array.
 *
 * Idea:
 * - Use Binary Search
 * - When target is found:
 *     - For FIRST → continue searching LEFT
 *     - For LAST → continue searching RIGHT
 *
 * Uses:
 * - left, right: search boundaries
 * - mid: middle index
 * - result: stores best index found so far
 *
 * Time Complexity:
 * - O(log n)
 *
 * Space Complexity:
 * - O(1)
 */

public class FirstLastOccurance {
    /**
     * Finds first occurrence of target
     */
    public static int first(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;       // store answer
                right = mid - 1;   // go LEFT
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * Finds last occurrence of target
     */
    public static int last(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;      // store answer
                left = mid + 1;    // go RIGHT
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4};

        System.out.println("First: " + FirstLastOccurance.first(arr, 2)); 
        System.out.println("Last: " + FirstLastOccurance.last(arr, 2));  
    }
}