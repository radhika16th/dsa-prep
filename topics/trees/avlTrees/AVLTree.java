/**
 * AVL Tree
 *
 * An AVL Tree is a self-balancing Binary Search Tree (BST).
 *
 * Property:
 * For every node:
 *
 *      | height(left) - height(right) | <= 1
 *
 * If inserting a value causes the tree to become unbalanced,
 * rotations are performed to restore balance.
 *
 * Time Complexity:
 * Insert  : O(log n)
 * Search  : O(log n)
 * Delete  : O(log n)
 */

public class AVLTree {
    // Root node of the AVL tree
    AVLNode root; 

    /**
     * Returns the height of a node.
     *
     * If the node is null, its height is 0.
     */
    public static int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }
    
    /**
     * Calculates the balance factor of a node.
     *
     * Formula:
     *      Balance = Height(Left Subtree) - Height(Right Subtree)
     */
    private int getBalance(AVLNode node) {
        if (node == null)   
            return 0;
        return height(node.left) - height(node.right);
    }

    /**
     * Inserts a value into the AVL Tree.
     *
     * Steps:
     * 1. Perform normal BST insertion.
     * 2. Update node height.
     * 3. Calculate balance factor.
     * 4. Perform rotations if tree becomes unbalanced.
     *
     * Returns the new root of the subtree.
     */
    public AVLNode insert(AVLNode node, int value) {
        // Normal BST insert

        // Empty spot found, create a new node
        if (node == null)  
            return new AVLNode(value);

        // Go left if value is smaller
        if (value < node.value)
            node.left = insert(node.left, value);

        // Go right if value is larger
        else    
            node.right = insert(node.right, value);

        // Update the height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance
        int balance = getBalance(node);

        // Rotations
        // LL Case
        /*
         * Example:
         *
         *      30
         *     /
         *    20
         *   /
         *  10
         *
         * Fix:
         * Right Rotation
         */
        if (balance > 1 && value < node.left.value)
            return AVLRotations.rightRotate(node);

        // RR Case
        /*
         * Example:
         *
         * 10
         *   \
         *   20
         *     \
         *     30
         *
         * Fix:
         * Left Rotation
         */
        if (balance < -1 && value > node.right.value)
            return AVLRotations.leftRotate(node);

        // LR Case
        /*
         * Example:
         *
         *      30
         *     /
         *   10
         *     \
         *     20
         *
         * Fix:
         * 1. Left Rotate child
         * 2. Right Rotate parent
         */
        if (balance > 1 && value > node.left.value) {
            node.left = AVLRotations.leftRotate(node.left);
            return AVLRotations.rightRotate(node);
        }

        // RL Case
        /*
         * Example:
         *
         * 10
         *   \
         *   30
         *   /
         * 20
         *
         * Fix:
         * 1. Right Rotate child
         * 2. Left Rotate parent
         */
        if (balance < -1 && value < node.right.value) {
            node.right = AVLRotations.rightRotate(node.right);
            return AVLRotations.leftRotate(node);
        }

        return node;
    }

    /**
     * Inorder Traversal
     *
     * Left -> Root -> Right
     *
     * For a BST (and AVL Tree),
     * inorder traversal always prints values
     * in sorted order.
     */
    public void inOrder(AVLNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30); // triggers rotation
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 5);

        System.out.print("Inorder: ");
        tree.inOrder(tree.root); // sorted
    }
}