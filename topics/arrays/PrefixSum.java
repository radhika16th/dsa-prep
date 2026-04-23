/**
 * Gives the sum of the current element + the previous elements
 * 
 * best: O(n)
 * space: O(n)
 */

public class PrefixSum {
    private final static int[] data = new int[]{2, 4, 6, 8, 10};

    public static int[] prefix(int[] data) {
        int[] sum = new int[data.length];
        int val = 0;

        for (int i = 0; i < data.length; i++) {
            val += data[i];
            sum[i] = val;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] sum = PrefixSum.prefix(data);
        Basics.traversal(sum);
    }
}