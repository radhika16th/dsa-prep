public class Reverse {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
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