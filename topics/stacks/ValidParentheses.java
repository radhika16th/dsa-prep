/**
 * Checks if a string of parentheses is valid.
 * Uses a stack to ensure every opening bracket
 * has a matching closing bracket in correct order.
 * 
 * Uses:
 * - stack: stores opening brackets
 * 
 * Operations:
 * - push opening brackets
 * - pop and match when a closing bracket is found
 * 
 * best: O(n)
 * worst: O(n)
 * space: O(n)
 */

import java.util.Stack;

public class ValidParentheses {
    public static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>(); // stack to store opening brackets

        // iterate through each character
        for (char c : s.toCharArray()) {
            // if opening bracket → push
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            
            // if closing bracket
            else {
                // no matching opening bracket
                if (stack.isEmpty()) 
                    return false;

                char top = stack.pop(); // pop last opening bracket

                // check for mismatch
                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') 
                    return false;
            }
        }

        // valid only if no unmatched brackets remain
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParentheses("{()[]"));
        System.out.println(validParentheses("{[()]}"));
    }
}