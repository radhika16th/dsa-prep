/**
 * Deletes a node from a Binary Search Tree (BST).
 *
 * Idea:
 * - Search for the node
 * - Handle 3 cases:
 *   1. No child → remove node
 *   2. One child → replace with child
 *   3. Two children → replace with inorder successor (min of right subtree)
 *
 * Uses:
 * - root: current node
 * - key: value to delete
 *
 * Time Complexity:
 * - O(h), where h = height of tree
 *
 * Space Complexity:
 * - O(h) (recursion stack)
 */

public class DeleteBST {
    /**
     * Deletes a node with given key and returns updated root
     */
    public TreeNode2 delete(TreeNode2 root, int key) {
        // Base case: node not found
        if (root == null)
            return null;

        // Search left
        if (key < root.value)
            root.left = delete(root.left, key);
        
        // Search right
        else if (key > root.value)
            root.right = delete(root.right, key);

        // Node found
        else {
            // Case 1: no left child
            if (root.left == null)
                return root.right;

            // Case 2: no right child
            if (root.right == null)
                return root.left;

            // Case 3: two children
            // Find inorder successor (smallest in right subtree)
            TreeNode2 minNode = MinMaxBST.findMin(root.right);
            root.value = minNode.value; // Replace value
            root.right = delete(root.right, minNode.value); // Delete successor
        }

        return root;
    }

    public static void main(String[] args) {
        InsertBST insertObj = new InsertBST();
        DeleteBST deleteObj = new DeleteBST();

        TreeNode2 root = null;

        // Build BST
        root = insertObj.insert(root, 10);
        root = insertObj.insert(root, 5);
        root = insertObj.insert(root, 15);
        root = insertObj.insert(root, 3);
        root = insertObj.insert(root, 7);

        System.out.print("Before delete (inorder): ");
        insertObj.inOrder(root); // 3 5 7 10 15
        System.out.println();

        // Delete node
        root = deleteObj.delete(root, 5);

        System.out.print("After delete (inorder): ");
        insertObj.inOrder(root); // 3 7 10 15
        System.out.println();
    }
}