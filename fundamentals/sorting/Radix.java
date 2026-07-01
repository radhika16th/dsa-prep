import java.util.Arrays;

/**
 * Radix Sort Algorithm
 *
 * Idea:
 * - Sort numbers digit by digit (ones, tens, hundreds...)
 * - Use Counting Sort for each digit
 *
 * Time Complexity: O(n * d)
 * d = number of digits
 *
 * Space Complexity: O(n)
 */

public class Radix {
    /**
     * Main radix sort function
     */
    public void radixSort(int[] arr) {
        // Find largest number (to know number of digits)
        int max = getMax(arr);

        // Apply counting sort for each digit
        for (int exp = 1; max/exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * Finds maximum element in array
     */
    private int getMax(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            if (num > max) max = num;
        }

        return max;
    }

    /**
     * Counting sort based on digit (exp = 1, 10, 100...)
     */
    private void countingSort(int[] arr, int exp) {
        int n = arr.length;

        int output[] = new int[n]; // sorted array
        int[] count = new int[10]; // digits 0–9

        // Count occurrences of digits
        for (int i = 0; i < n; i++) {
            int digit = (arr[i]/exp) % 10;
            count[digit]++;
        }

        // Convert count to prefix sum (positions)
        for (int i = 1; i < 10; i++)
            count[i] += count[i-1];

        // Build output array (right to left → stable sort)
        for (int i = n-1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;

            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy back to original array
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        Radix rs = new Radix();
        rs.radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}