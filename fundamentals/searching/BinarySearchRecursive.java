/**
 * Binary Search (Recursive)
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(log n) (recursion stack)
 */
public class BinarySearchRecursive {
    public static int search(int[] arr, int target, int left, int right) {
        // base case
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        // found
        if (arr[mid] == target) {
            return mid;
        }

        // search right half
        if (arr[mid] < target) {
            return search(arr, target, mid + 1, right);
        }

        // search left half
        return search(arr, target, left, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int result = search(arr, 30, 0, arr.length - 1);

        System.out.println("Index: " + result); // 2
    }
}