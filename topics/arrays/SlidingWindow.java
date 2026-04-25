/**
 * Finds the maximum sum of any subarray of size k.
 * Maintains a running sum by removing the leftmost element
 * and adding the next element as the window slides.
 * 
 * best: O(n)
 * worst: O(n)
 * space: O(1)
 */

public class SlidingWindow {
    private final static int[] data = new int[]{2, 4, 19, 20, 43, 25, 93, 82, 20, 21, 0, 1, 45, 43};

    public static void maxSum(int[] data, int size) {
        int currentSum = sum(data, 0, size);
        int max = currentSum;
        int maxStart = 0; // track the max window

        // slide the window from size to end
        for (int i = size; i < data.length; i++) {
            currentSum -= data[i - size]; // remove the element leaving
            currentSum += data[i]; // add the element entering

            // if max sum
            if (max < currentSum) {
                max = currentSum;
                maxStart = i - size + 1; // update the starting index
            }
        }

        // output the max sum
        System.out.println("The max sum is " + max);
        
        // output the subarray
        System.out.println("The subarray is \n");
        for (int i = maxStart; i < maxStart + size; i++)
            System.out.print(data[i] + " ");
    }

    // helper for summation, from start to end indexes (inclusive)
    public static int sum(int[] data, int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += data[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        SlidingWindow.maxSum(data, 3);
    }
}