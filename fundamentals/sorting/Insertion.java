import java.util.ArrayList;

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
        for (int k = 1; k < arr.length; k++) {
            int current = arr[k];
            int j = k;

            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = current;
        }
    }

    // ArrayList (shift elements)
    public void insertionSortArrayList(ArrayList<Integer> list) {
        for (int k = 1; k < list.size(); k++) {
            int current = list.get(k);
            int j = k;

            while (j > 0 && list.get(j - 1) > current) {
                list.set(j, list.get(j - 1));
                j--;
            }

            list.set(j, current);
        }
    }
}