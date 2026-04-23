/**
 * Finds two indices in a sorted array such that their values sum to a target.
 * Uses two pointers moving inward based on comparison with the target.
 * 
 * best: O(n)
 * worst: O(n)
 * space: O(1)
 */

import java.util.Arrays;

public class TwoPointers {
    private final static int[] data = new int[]{1, 2, 3, 5, 6, 9};

    public static void findSum(int[] data, int sum) {
        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            int currentSum = data[left] + data[right];
            
            // move right pointer if bigger
            if (currentSum > sum)
                right--;
            
            // move left pointer if smaller
            else if (currentSum < sum)
                left++;

            // found / left > right
            else
                break;
        }

        // if within bounds and found sum
        if (left < right && data[left] + data[right] == sum) {
            System.out.println(data[left] + ", " + data[right]);
        }
        else {
            System.out.println("no pairs found.");
        }
    }

    public static void main(String[] args) {
        int[] sortedData = data.clone();
        Arrays.sort(sortedData);
        TwoPointers.findSum(sortedData, 8);
    }
}