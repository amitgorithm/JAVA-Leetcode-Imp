// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

public class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            // Swap s[left] and s[right]
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
