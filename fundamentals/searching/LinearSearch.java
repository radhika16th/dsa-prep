import java.util.*;

/**
 * Linear Search
 *
 * Idea:
 * - Check each element one by one
 * - Return index if found
 * - Return -1 if not found
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LinearSearch {
    public static int search(int[] arr, int target) {
        // go through each element
        for (int i = 0; i < arr.length; i++) {
            // if found
            if (arr[i] == target) {
                return i;
            }
        }

        // not found
        return -1;
    }

    public static List<Integer> searchAll(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int result = search(arr, 30);

        System.out.println("Index: " + result);
    }
}