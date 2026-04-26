/**
 * Uses the Fast and Slow Pointer technique on a singly linked list.
 * 
 * - findMiddle: finds the middle node of the list
 * - hasCycle: detects if the list contains a cycle
 * 
 * Uses two pointers:
 * - slow: moves one step at a time
 * - fast: moves two steps at a time
 * 
 * For findMiddle:
 * best: O(1) - single node
 * worst: O(n)
 * space: O(1)
 * 
 * For hasCycle:
 * best: O(1) - cycle detected immediately
 * worst: O(n)
 * space: O(1)
 */

public class FastSlowPointer {
    // find the middle node of the linked list
    public static ListNode findMiddle(ListNode head) {
        // both pointers start at head
        ListNode slow = head;
        ListNode fast = head;

        // move until fast reaches end
        while (fast != null && fast.next != null) {
            slow = slow.next; // slow moves one step
            fast = fast.next.next; // fast moves two steps
        }

        // slow will be at the middle
        return slow;
    }

    // detect if a cycle exists in the list
    public static boolean hasCycle(ListNode head) {
        // initialize both pointers
        ListNode slow = head;
        ListNode fast = head;

        // traverse list
        while (fast != null && fast.next != null) {
            slow = slow.next; // slow moves one step
            fast = fast.next.next; // fast moves two steps

            // if they meet → cycle exists
            if (slow == fast)
                return true;
        }

        return false;  // reached end → no cycle
    }

    public static void main(String[] args) {
        ListNode head = null;

        head = LinkedBasics.insert(head, 1);
        head = LinkedBasics.insert(head, 2);
        head = LinkedBasics.insert(head, 3);
        head = LinkedBasics.insert(head, 4);
        head = LinkedBasics.insert(head, 5);
        head = LinkedBasics.insert(head, 6);

        // find middle
        ListNode mid = findMiddle(head);
        System.out.println("Middle: " + mid.value);

        // create cycle manually
        ListNode temp = head;
        while (temp.next != null) { // go to last node
            temp = temp.next;
        }
        temp.next = head.next; // connect last node to second node (value 2)
        
        System.out.println("Has cycle: " + hasCycle(head)); // true
    }
}