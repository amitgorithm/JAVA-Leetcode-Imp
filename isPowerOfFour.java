// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 4x.

class Solution {
    public boolean isPowerOfFour(int n) {
        // Check if n is a power of 2 (only one bit set) and that bit is in the correct (even) position
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}

// alternate approach (iterative)

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 1) return false;

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }
}
