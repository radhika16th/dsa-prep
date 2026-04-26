/**
 * Demonstrates a linked list using both head and tail pointers.
 * Allows efficient insertion at the end in O(1) time.
 * 
 * Uses two pointers:
 * - head: points to the first node
 * - tail: points to the last node
 * 
 * best: O(1) insertion
 * worst: O(1) insertion
 * space: O(n)
 */

public class HeadTailExample {
    ListNode head = null;
    ListNode tail = null;

    // insert at end in O(1)
    public void insert(int val) {
        ListNode newNode = new ListNode(val);

        // if list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode; // attach new node at the end
            tail = newNode; // move tail forward
        }
    }

    // print
    public void print() {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        HeadTailExample list = new HeadTailExample();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.print();
    }
}