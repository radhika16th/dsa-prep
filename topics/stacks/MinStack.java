/**
 * Implements a Min Stack using two stacks.
 * Follows LIFO (Last In, First Out) principle.
 *
 * Idea:
 * - One stack (stack) stores all elements
 * - Another stack (minStack) keeps track of minimum values
 *
 * Uses:
 * - stack: main stack storing all values
 * - minStack: stores the minimum at each stage
 *
 * Operations:
 * - push: insert element at top
 * - pop: remove element from top
 * - getMin: retrieve minimum element in O(1)
 *
 * Time Complexity:
 * - push: O(1)
 * - pop: O(1)
 * - getMin: O(1)
 *
 * Space Complexity:
 * - O(n) (extra stack used)
 */

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>(); // Main stack to store all values
    Stack<Integer> minStack = new Stack<>(); // Auxiliary stack to track minimum values

    /**
     * Pushes a value onto the stack.
     * Also updates minStack if the new value is smaller or equal.
     */
    public void push(int value) {
        stack.push(value);

        // If minStack is empty OR new value is smaller/equal, track it
        if (minStack.isEmpty() || value <= minStack.peek())
            minStack.push(value);
    }

    /**
     * Removes the top element from the stack.
     * Also removes from minStack if it was the minimum.
     */
    public void pop() {
        if (stack.isEmpty())
            return;

        int value = stack.pop(); // remove from main stack

        // If popped value is current minimum, remove from minStack too
        if (!minStack.isEmpty() && value == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * Returns the minimum element in the stack.
     */
    public int getMin() {
        return minStack.peek(); // top of minStack is always min
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

        s.push(5);
        s.push(2);
        s.push(8);

        System.out.println(s.getMin()); // 2
        s.pop();
        System.out.println(s.getMin()); // 2
    }
}