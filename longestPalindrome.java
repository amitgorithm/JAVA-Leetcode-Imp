/** 
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters. Letters are case sensitive, for example, "Aa" is not considered a palindrome.
**/

import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128]; // ASCII characters
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        int len = 0;
        boolean odd = false;
        for (int f : freq) {
            if (f % 2 == 0) {
                len += f;
            } else {
                len += f - 1;
                odd = true;
            }
        }
        return odd ? len + 1 : len;
    }
}
