# Write leetcode acceptable program for:



# Given a string s, return the longest palindromic substring in s.

 

# Example 1:

# Input: s = "babad"Output: "bab"Explanation: "aba" is also a valid answer.

# Example 2:

# Input: s = "cbbd"Output: "bb"

 

# Constraints:

# 1 <= s.length <= 1000

# s consist of only digits and English letters.

# #include <string>
# #include <vector>
# #include <iostream>

# using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) return "";

        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand for odd length (center is single char)
            expandAroundCenter(s, i, i, start, maxLen);
            // Expand for even length (center is between two chars)
            expandAroundCenter(s, i, i + 1, start, maxLen);
        }

        return s.substr(start, maxLen);
    }

private:
    void expandAroundCenter(const string& s, int left, int right, int& start, int& maxLen) {
        while (left >= 0 && right < s.length() && s[left] == s[right]) {
            left--;
            right++;
        }
        // Length of the palindrome is (right - 1) - (left + 1) + 1 = right - left - 1
        int currentLen = right - left - 1;
        if (currentLen > maxLen) {
            maxLen = currentLen;
            start = left + 1;
        }
    }
};
