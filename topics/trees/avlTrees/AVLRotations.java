/**
 * AVL Rotations
 *
 * Rotations are used to rebalance an AVL Tree when
 * inserting or deleting nodes causes the balance factor
 * to become greater than 1 or less than -1.
 *
 * Types:
 * 1. Right Rotation  (fixes LL imbalance)
 * 2. Left Rotation   (fixes RR imbalance)
 *
 * LR and RL cases are combinations of these two rotations.
 */
public class AVLRotations {
    /**
     * RIGHT ROTATION
     *
     * Used to fix a Left-Left (LL) imbalance.
     *
     * Before:
     *
     *        y
     *       /
     *      x
     *     /
     *    A
     *
     * After:
     *
     *        x
     *       / \
     *      A   y
     *
     * T2 must be saved because it would otherwise
     * be lost during the rotation.
     *
     * Returns the new root of the subtree.
     */
    public static AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left; // x becomes the new root
        AVLNode T2 = x.right; // Store x's right subtree temporarily

        // Rotation
        x.right = y; // Move y down to the right
        y.left = T2; // Attach saved subtree

        // Update heights
        y.height = Math.max(AVLTree.height(y.left), AVLTree.height(y.right)) + 1;
        x.height = Math.max(AVLTree.height(x.left), AVLTree.height(x.right)) + 1;

        return x;
    }

    /**
     * LEFT ROTATION
     *
     * Used to fix a Right-Right (RR) imbalance.
     *
     * Before:
     *
     *      x
     *       \
     *        y
     *         \
     *          A
     *
     * After:
     *
     *         y
     *        / \
     *       x   A
     *
     * T2 must be saved because it would otherwise
     * be lost during the rotation.
     *
     * Returns the new root of the subtree.
     */
    public static AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right; // y becomes the new root
        AVLNode T2 = y.left; // Store y's left subtree temporarily

        // Rotation
        y.left = x; // Move x down to the left
        x.right = T2; // Attach saved subtree

        // Update heights
        x.height = Math.max(AVLTree.height(x.left), AVLTree.height(x.right)) + 1;
        y.height = Math.max(AVLTree.height(y.left), AVLTree.height(y.right)) + 1;

        return y;
    }
}