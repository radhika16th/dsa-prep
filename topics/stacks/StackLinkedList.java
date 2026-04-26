/**
 * Implements a stack using a singly linked list.
 * Follows LIFO (Last In, First Out) principle.
 * 
 * Uses:
 * - top: pointer to the top node of the stack
 * - size: tracks the current number of elements
 * 
 * Operations:
 * - push: insert element at top
 * - pop: remove element from top
 * - top: view top element
 * - isEmpty: check if stack is empty
 * 
 * push: O(1)
 * pop: O(1)
 * top: O(1)
 * space: O(n)
 */

public class StackLinkedList {
    StackListNode top; // pointer to top node
    int size; // tracks current number of elements

    // push element onto stack
    public void push(int value) {
        StackListNode newNode = new StackListNode(value); // create new node
        newNode.next = top; // point new node to current top
        top = newNode; // update top to new node
        size++;
    }

    // pop element from stack
    public int pop() {
        // check for underflow
        if (top == null)
            return -1;
        
        int value = top.value; // store value to return
        top = top.next; // move top to next node
        size--;
        return value;
    }

    // peek at top element
    public int top() {
        if (top == null)    
            return -1;

        return top.value;
    }

    // check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // return current number of elements
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();

        // pushed 10, 20, 30
        for (int i = 1; i <= 3; i++) {
            s.push(i*10);
        }

        System.out.println("Top: " + s.top());  // 30

        s.push(40);
        System.out.println("Pushed " + s.top()); // 40

        System.out.println("Popped: " + s.pop()); // 40
        System.out.println("Top: " + s.top()); // 30

        System.out.println("Size: " + s.size());
        System.out.println("Empty: " + s.isEmpty());
    }
}