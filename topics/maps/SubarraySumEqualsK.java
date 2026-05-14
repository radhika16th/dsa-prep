/**
 * Counts the number of subarrays whose sum equals k.
 *
 * Problem:
 * - Given an integer array and an integer k,
 *   return the total number of continuous subarrays whose sum = k.
 *
 * Idea (Prefix Sum):
 * - Keep a running sum
 * - If (currentSum - k) exists in map → a valid subarray exists
 * - Map stores: prefixSum → frequency
 *
 * Key Insight:
 * - If sum[j] - sum[i] = k → subarray (i+1 to j) has sum k
 *
 * Uses:
 * - map: stores prefix sum frequencies
 *
 * Time Complexity:
 * - O(n)
 *
 * Space Complexity:
 * - O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    /**
     * Returns number of subarrays with sum = k
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // Map to store prefix sum; frequency
        map.put(0, 1); // Base case: prefix sum 0 occurs once

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num; // Update running sum

            if (map.containsKey(sum - k)) // Check if (sum - k) exists
                count += map.get(sum - k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1); // Store current sum frequency
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();

        int[] nums = {1, 1, 1, -1, 3};
        int k = 2;

        int result = obj.subarraySum(nums, k);

        System.out.println("Number of subarrays: " + result);
    }
}