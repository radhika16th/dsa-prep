import java.util.Arrays;

/**
 * Merge Sort Algorithm
 *
 * Idea:
 * - Divide array into halves
 * - Sort each half
 * - Merge sorted halves
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

public class Merge {

    /**
     * Recursively divides the array
     */
    public void mergeSort(int[] arr, int left, int right) {

        // Base case: 1 element → already sorted
        if (left >= right)
            return;

        int mid = left + (right - left) / 2; // Find middle index

        mergeSort(arr, left, mid); // Sort left half
        mergeSort(arr, mid+1, right); // Sort right half
        merge(arr, left, mid, right); // Merge both sorted halves
    }

    /**
     * Merges two sorted halves into one sorted array
     */
    private void merge(int[] arr, int left, int mid, int right) {
        // Sizes of left and right subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;   

        // Temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data into left array
        for (int i = 0; i < n1; i++) 
            leftArr[i] = arr[left + i];
        
        // Copy data into right array
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];
        
        // Pointers for leftArr, rightArr, and main array
        int i = 0, j = 0, k = left;

        // Pointers for leftArr, rightArr, and main array
        while(i < n1 && j < n2) {
            // Take smaller value
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }

            else {
                arr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from leftArr
        while (i < n1) {
            arr[k] = leftArr[i];
            i++; 
            k++;
        }

        // Copy remaining elements from rightArr
        while (j < n2) {
            arr[k] = rightArr[j];
            j++; 
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        Merge ms = new Merge();
        ms.mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}