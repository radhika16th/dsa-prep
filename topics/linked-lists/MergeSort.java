/**
 * Merges two sorted singly linked lists into one sorted list.
 * Compares nodes from both lists and attaches the smaller one
 * to the result list using a dummy node.
 * 
 * Uses two pointers:
 * - node1: traverses first list
 * - node2: traverses second list
 * - tail: builds the merged list
 * 
 * best: O(n + m)
 * worst: O(n + m)
 * space: O(1)
 */

public class MergeSort {
    public static ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode(0); // dummy node
        ListNode tail = dummyNode; // tail will build the new merged list

        // traverse both lists until one is exhausted
        while (node1 != null && node2 != null) {
            // compare values and attach smaller node
            if (node1.value < node2.value) {
                tail.next = node1; // attach node1
                node1 = node1.next; // move node1 forward
            }

            else {
                tail.next = node2; // attach node2
                node2 = node2.next; // move node2 forward
            }

            tail = tail.next; // move tail forward
        }

        // attach remaining nodes (only one list will have nodes left)
        if (node1 != null) 
            tail.next = node1;
        else
            tail.next = node2;

        return dummyNode.next; // return merged list (skip dummy node)
    }

    public static void main(String[] args) {
        // first list: 1 -> 2 -> 3
        ListNode head1 = null;
        head1 = LinkedBasics.insert(head1, 1);
        head1 = LinkedBasics.insert(head1, 2);
        head1 = LinkedBasics.insert(head1, 7);
        LinkedBasics.print(head1);

        // second list: 4 -> 5 -> 6
        ListNode head2 = null;
        head2 = LinkedBasics.insert(head2, 4);
        head2 = LinkedBasics.insert(head2, 5);
        head2 = LinkedBasics.insert(head2, 6);
        LinkedBasics.print(head2);

        // merge lists
        ListNode mergeList = merge(head1, head2);
        LinkedBasics.print(mergeList);
    }
}