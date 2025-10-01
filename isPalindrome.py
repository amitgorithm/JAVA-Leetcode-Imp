#** Given an integer x, return true if x is a palindrome, and false otherwise.

 

#Example 1:

#Input: x = 121
#Output: true
#Explanation: 121 reads as 121 from left to right and from right to left.
##

class Solution:
    def isPalindrome(self, x):
        # Negative numbers are not palindrome
        if x < 0:
            return False
        
        # Numbers ending with 0 (but not 0 itself) cannot be palindrome
        if x % 10 == 0 and x != 0:
            return False

        reversed_half = 0
        while x > reversed_half:
            reversed_half = reversed_half * 10 + x % 10
            x //= 10
        
        # For even length, x == reversed_half
        # For odd length, drop the middle digit: x == reversed_half // 10
        return x == reversed_half or x == reversed_half // 10
