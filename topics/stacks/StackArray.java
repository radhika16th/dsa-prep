/**
 * Implements a stack using an ArrayList.
 * Follows LIFO (Last In, First Out) principle.
 * 
 * Uses:
 * - stack: dynamic array to store elements
 * - top: index of the top element
 * - size: maximum capacity of the stack
 * 
 * Operations:
 * - push: add element to top
 * - pop: remove element from top
 * - top: view top element
 * - isEmpty: check if stack is empty
 * 
 * push: O(1)
 * pop: O(1)
 * top: O(1)
 * space: O(n)
 */

import java.util.ArrayList;

public class StackArray {
    ArrayList<Integer> stack; // underlying storage for stack
    int top; // index of top element
    int size; // maximum capacity

    public StackArray(int size) {
        this.size = size;
        stack = new ArrayList<>(size);
        top = -1;  // stack starts empty
    }

    // push element onto stack
    public void push(int value) {
        // check for overflow
        if (top == size - 1) {
            System.out.println("Stack overflow");
            return;
        }

        stack.add(++top, value); // move top and insert value
    }

    // pop element from stack
    public int pop() {
        // check for underflow
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }

        // remove and return top element
        return stack.remove(top--);
    }

    // peek at top element
    public int top() {
        if (top == -1)
            return -1;
        return stack.get(top);
    }

    // check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

     // return current number of elements
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackArray s = new StackArray(5);

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