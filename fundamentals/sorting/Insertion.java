import java.util.ArrayList;
import java.util.Arrays;

/**
 * Insertion Sort 
 * 
 * best: O(n) - already sorted
 * worst: O(n^2)
 * space: O(1)
 */

public class Insertion {
    // Array (shift elements)
    public void insertionSortArray(int[] arr) {
         /**
          * Start at index 1 because:
          * The first element is already considered sorted.
          */
        for (int k = 1; k < arr.length; k++) {
            int current = arr[k]; // Element we want to insert into the sorted portion
            int j = k; // j is used to move backwards through the sorted portion.

            // Move larger elements one position to the right.
            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1]; // Shift element right.
                j--; // Move left
            }

            // Insert current value into its correct sorted position.
            arr[j] = current;
        }
    }

    // ArrayList (shift elements)
    public void insertionSortArrayList(ArrayList<Integer> list) {
        // Start from second element
        for (int k = 1; k < list.size(); k++) {
            int current = list.get(k); // Value we want to insert
            int j = k; // Position pointer

            // Move larger elements one position to the right.
            while (j > 0 && list.get(j - 1) > current) {
                list.set(j, list.get(j - 1)); // Copy left value into current position.
                j--; // Move left
            }

            // Insert current value into its correct sorted position.
            list.set(j, current);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        Insertion ss = new Insertion();
        ss.insertionSortArray(arr);

        System.out.println(Arrays.toString(arr));
    }
}