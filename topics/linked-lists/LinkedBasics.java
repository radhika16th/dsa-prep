/**
 * Basics of Linked Lists
 */

public class LinkedBasics {
    // insert
    public static ListNode insert(ListNode head, int val) {
        // Create the node that will be appended to the list.
        ListNode newNode = new ListNode(val);

        // An empty list becomes a single-node list.
        if (head == null)
            return newNode;

        // Walk to the last node and attach the new node there.
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    // traverse
    public static void traverse(ListNode head) {
        // Visit each node from left to right and print its value.
        ListNode current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    // print
    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    // add at the head
    public static ListNode addFirst(ListNode head, int value) {
        ListNode newNode = new ListNode(value); // create new node

        // if list empty
        if (head == null)
            return newNode;

        // point new node to the current head
        newNode.next = head;

        head = newNode; // update the head

        return head;
    }


    public static void main(String[] args) {
        ListNode head = null;

        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);

        traverse(head);
        print(head);

        head = addFirst(head, 0);
        print(head);
    }
}