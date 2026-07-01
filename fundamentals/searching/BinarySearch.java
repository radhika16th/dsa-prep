/**
 * Binary Search (Iterative)
 *
 * Works on SORTED array
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // found
            if (arr[mid] == target) {
                return mid;
            }

            // go right
            else if (arr[mid] < target) {
                left = mid + 1;
            }

            // go left
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int result = search(arr, 30);

        System.out.println("Index: " + result); 
    }
}