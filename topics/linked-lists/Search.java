/**
 * Searches for a value in a singly linked list.
 * Traverses the list node by node until the value is found
 * or the end of the list (null) is reached.
 * 
 * Uses one pointer:
 * - current: starts at the head and moves through each node
 * 
 * best: O(1) - value found at head
 * worst: O(n) - value at end or not present
 * space: O(1)
 */

public class Search {
    public static boolean search(ListNode head, int value) {
        ListNode current = head; // start from head

        // traverse list
        while (current != null) {
            // check if the value matches
            if (current.value == value)
                return true;
            
            // move to the next node
            current = current.next;
        }

        return false; // value not found
    }

    public static void main(String[] args) {
        ListNode head = null;

        head = LinkedBasics.insert(head, 1);
        head = LinkedBasics.insert(head, 2);
        head = LinkedBasics.insert(head, 3);

        System.out.print("The List: ");
        LinkedBasics.print(head);

        System.out.println("Search 2: " + search(head, 2)); // true
        System.out.println("Search 10: " + search(head, 10)); // false
    }
}