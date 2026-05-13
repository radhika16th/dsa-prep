import java.util.HashMap;
import java.util.Map;

/**
 * Solves the Two Sum problem using a HashMap.
 *
 * Problem:
 * - Given an array of integers and a target value,
 *   return indices of two numbers such that they add up to the target.
 *
 * Idea:
 * - Iterate through the array
 * - For each number, compute: difference = target - current value
 * - Check if difference already exists in the map
 * - If yes → solution found
 * - Otherwise, store current number with its index
 *
 * Uses:
 * - map: stores value → index pairs
 *
 * Time Complexity:
 * - O(n)
 *
 * Space Complexity:
 * - O(n)
 */

public class TwoSum {
    /**
     * Returns indices of two numbers that sum to target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Map to store value → index

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i]; // Find required pair value

            // Check if complement exists
            if (map.containsKey(difference))
                return new int[]{map.get(difference), i}; // Return indices of the two numbers

            map.put(nums[i], i); // Store current value with index
        }

        // No solution found
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = obj.twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}