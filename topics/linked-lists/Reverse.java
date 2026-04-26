/**
 * Reverses a singly linked list in-place.
 * Iterates through the list and reverses the direction of each pointer.
 * 
 * Uses three pointers:
 * - prev: keeps track of the previous node (initially null)
 * - curr: current node being processed
 * - next: temporarily stores the next node to avoid losing reference
 * 
 * best: O(n)
 * worst: O(n)
 * space: O(1)
 */

public class Reverse {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // prev will become the new head at the end
        ListNode curr = head; // curr starts at the original head

        // traverse the list
        while (curr != null) {
            ListNode next = curr.next; // store next node before breaking the link
            curr.next = prev; // reverse the current node's pointer
            prev = curr; // move prev forward 
            curr = next; // move curr forward using saved next node
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = null;

        head = LinkedBasics.insert(head, 1);
        head = LinkedBasics.insert(head, 2);
        head = LinkedBasics.insert(head, 3);

        System.out.print("Original: ");
        LinkedBasics.print(head);

        System.out.print("\nReversed: ");
        head = reverseList(head);
        LinkedBasics.print(head);
    }
}