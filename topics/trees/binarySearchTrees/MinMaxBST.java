/**
 * Finds minimum and maximum values in a Binary Search Tree (BST).
 *
 * Idea:
 * - In a BST:
 *     - Leftmost node = smallest value
 *     - Rightmost node = largest value
 *
 * Uses:
 * - node: starting root of BST
 *
 * Time Complexity:
 * - O(h), where h = height of tree
 *
 * Space Complexity:
 * - O(1) (iterative)
 */

public class MinMaxBST {
    /**
     * Returns node with minimum value
     */
    public static TreeNode2 findMin(TreeNode2 node) {
        // Traverse to the leftmost node
        while (node.left != null)
            node = node.left;
        return node;
    }

    /**
     * Returns node with maximum value
     */
    public static TreeNode2 findMax(TreeNode2 node) {
        // Traverse to the rightmost node
        while (node.right != null)
            node = node.right;
        return node;
    }

    /**
     * Helper function to print min and max
     */
    public static void helper(TreeNode2 node, String s) {
        // If node exists
        if (node != null) {
            if (s.equals("min"))
                System.out.println("Min: " + node.value);
            else    
                System.out.println("Max: " + node.value);
        }
        
        // doesn't exist
        else {
            if (s.equals("min"))
                System.out.println("Min: null");
            else    
                System.out.println("Max: null");
        }
    }

    public static void main(String[] args) {
        InsertBST obj = new InsertBST();
        TreeNode2 root = null;

        // Insert values
        root = obj.insert(root, 10);
        root = obj.insert(root, 5);
        root = obj.insert(root, 15);
        root = obj.insert(root, 3);
        root = obj.insert(root, 7);

        // Find minNode, maxNode
        helper(findMin(root), "min");
        helper(findMax(root), "max");
    }
}