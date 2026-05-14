/**
 * Searches for a value in a Binary Search Tree (BST).
 *
 * Idea:
 * - In a BST:
 *     left subtree < root < right subtree
 * - Compare key with current node:
 *     - If equal → found
 *     - If smaller → search left
 *     - If larger → search right
 *
 * Uses:
 * - pos: current node
 * - key: value to search for
 *
 * Time Complexity:
 * - O(h), where h = height of tree
 * - O(log n) for balanced BST
 * - O(n) worst-case (skewed tree)
 *
 * Space Complexity:
 * - O(h) (recursion stack)
 */

public class SearchBST {
    /**
     * Returns the node containing the key, or null if not found
     */
    public TreeNode2 treeSearch(TreeNode2 pos, int key) {
        // Base case: node not found OR key found
        if (pos == null || pos.value == key)
            return pos;

        // Search left subtree
        if (key < pos.value)
            return treeSearch(pos.left, key);

        // Search right subtree
        else
            return treeSearch(pos.right, key);
    }

    /**
     * To search for the value
     */
    public static void result(SearchBST obj, TreeNode2 root, int key) {
        TreeNode2 result = obj.treeSearch(root, key);

        if (result != null)
            System.out.println("Found: " + result.value);
        else
            System.out.println("Not Found " + key);
    }

    public static void main(String[] args) {
        SearchBST obj = new SearchBST();

        // Build BST manually
        TreeNode2 root = new TreeNode2(10);
        root.left = new TreeNode2(5);
        root.right = new TreeNode2(15);
        root.left.left = new TreeNode2(2);
        root.left.right = new TreeNode2(7);

        result(obj, root, 7);
        result(obj, root, 3);
        result(obj, root, 10);
    }
}