/**
 * AVL Tree Implementation
 */
public class AVLNode {
    int value, height;
    AVLNode left, right;

    public AVLNode(int value) {
        this.value = value;
        this.height = 1;
    }
}