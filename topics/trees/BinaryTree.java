/**
 * Implements a Binary Tree with traversal and insertion.
 *
 * Idea:
 * - Each node has at most two children (left and right)
 * - Insertion is done level-by-level (BFS) to keep tree complete
 * - Traversals explore nodes in different orders
 *
 * Uses:
 * - root: starting node of the tree
 * - QueueTree: used for level-order insertion and traversal
 *
 * Traversals:
 * - Inorder (LNR): Left → Node → Right
 * - Preorder (NLR): Node → Left → Right
 * - Postorder (LRN): Left → Right → Node
 * - Level-order: BFS traversal using queue
 *
 * Time Complexity:
 * - insert: O(n)
 * - traversals: O(n)
 *
 * Space Complexity:
 * - O(n)
 */

public class BinaryTree {
    TreeNode root; // Root of the tree

    /**
     * Constructor initializes empty tree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Builds a sample tree manually
     */
    public void buildTree() {
        root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
    }

    /**
     * Inserts a node in level-order (BFS style)
     */
    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);

        // If tree is empty
        if (root == null) {
            root = newNode;
            return;
        }

        // Use queue for level-order traversal
        QueueTree q = new QueueTree(100);
        q.enqueue(root);

        while (true) {
            TreeNode current = q.dequeue();

             // Insert at first available left spot
            if (current.left == null) {
                current.left = newNode;
                return;
            }
            else 
                q.enqueue(current.left);

            // Insert at first available right spot
            if (current.right == null) {
                current.right = newNode;
                return;
            }
            else 
                q.enqueue(current.right);
        }
    }

    /**
     * Inorder traversal (Left → Node → Right)
     */
    public void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    /**
     * Preorder traversal (Node → Left → Right)
     */
    public void preOrder(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Postorder traversal (Left → Right → Node)
     */
    public void postOrder(TreeNode node) {
        if (node == null)
            return;
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    /**
     * Level-order traversal (BFS)
     */
    public void levelOrder() {
        if (root == null)
            return;

        QueueTree q = new QueueTree(100);
        q.enqueue(root);

        while (true) { 
            TreeNode current = q.dequeue();

            // Stop when queue is empty
            if (current == null)
                break;

            System.out.print(current.value + " ");
            
            // Add children to queue
            if (current.left != null)
                q.enqueue(current.left);

            if (current.right != null)
                q.enqueue(current.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.buildTree(); // Build initial tree

        System.out.print("Inorder: ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.print("Inorder: ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.print("Inorder: ");
        tree.postOrder(tree.root);
        System.out.println();

        System.out.print("Level Order: ");
        tree.levelOrder();
        System.out.println();

        tree.insert(7);
        System.out.print("Level Order after insert: ");
        tree.levelOrder();
    }
}