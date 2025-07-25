// write leetcode acceptable java program for the problem:
// An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

//  Given an integer n, return true if n is an ugly number.

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        // Divide out all 2s, 3s, and 5s
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        // If we're left with 1, it's ugly
        return n == 1;
    }
}
