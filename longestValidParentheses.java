/** Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring. 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'. **/


import java.util.Stack;

class Solution {
    /**
     * Given a string containing just the characters '(' and ')', return the length of the longest
     * valid (well-formed) parentheses substring.
     *
     * @param s The input string.
     * @return The length of the longest valid parentheses substring.
     */
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        
        // Push an initial index onto the stack. This serves as a base for
        // calculating the length of valid substrings.
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // If we encounter an opening parenthesis, push its index onto the stack.
                stack.push(i);
            } else {
                // If we encounter a closing parenthesis, pop an index from the stack.
                stack.pop();
                
                if (stack.isEmpty()) {
                    // If the stack becomes empty, it means we have a closing parenthesis
                    // that doesn't have a matching opening one.
                    // We push the current index to be the new base for future calculations.
                    stack.push(i);
                } else {
                    // If the stack is not empty, it means we've found a valid substring.
                    // The length is the current index minus the index of the top of the stack.
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}
