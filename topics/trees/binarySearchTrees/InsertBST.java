/**
 * Inserts a value into a Binary Search Tree (BST).
 *
 * Idea:
 * - In a BST:
 *     left subtree < root < right subtree
 * - Recursively find correct position:
 *     - If value < node → go left
 *     - If value ≥ node → go right
 * - Insert when a null position is found
 *
 * Uses:
 * - root: current node
 * - value: value to insert
 *
 * Time Complexity:
 * - O(h), where h = height of tree
 * - O(log n) for balanced BST
 * - O(n) worst-case (skewed tree)
 *
 * Space Complexity:
 * - O(h) (recursion stack)
 */

public class InsertBST {
    /**
     * Inserts a value into BST and returns updated root
     */
    public TreeNode2 insert(TreeNode2 root, int value) {
        // Base case: insert here
        if (root == null)
            return new TreeNode2(value);

        // Go left
        if (value < root.value)
            root.left = insert(root.left, value);

        // Go right
        else
            root.right = insert(root.right, value);
    
        return root;
    }

    /**
     * Helper method: inorder traversal (sorted output for BST)
     */
    public static void inOrder(TreeNode2 node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
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

        // inorder traversal
        inOrder(root); // 3 5 7 10 15
    }
}