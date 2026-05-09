/**
 * Computes the maximum depth (height) of a Binary Tree.
 *
 * Idea:
 * - Use recursion to explore both left and right subtrees
 * - Depth of a node = 1 + max(depth of left, depth of right)
 *
 * Uses:
 * - root: starting node of the tree
 *
 * Applications:
 * - Tree height calculation
 * - Used in balanced tree checks
 * - Helps in recursion-based tree problems
 *
 * Time Complexity:
 * - O(n) (visit each node once)
 *
 * Space Complexity:
 * - O(h) (recursion stack, where h = height of tree)
 */

public class MaxDepth {
    /**
     * Returns the maximum depth of the tree
     */
    public int maxDepth(TreeNode root) {
        // Base case: empty tree
        if (root == null) 
            return 0;

        int left = maxDepth(root.left); // Recursively get depth of left subtree
        int right = maxDepth(root.right); // Recursively get depth of right subtree

        return 1 + Math.max(left, right); // Return current node depth
    }

    public static void main(String[] args) {
        // Build tree 1
        BinaryTree tree = new BinaryTree();
        tree.buildTree();

        // Call maxDepth
        MaxDepth obj = new MaxDepth();
        int depth = obj.maxDepth(tree.root);
        System.out.println("Max Depth: " + depth);

        // Build tree 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);

        // Call maxDepth
        int depth2 = obj.maxDepth(root);
        System.out.println("Max Depth: " + depth2);
    }
}