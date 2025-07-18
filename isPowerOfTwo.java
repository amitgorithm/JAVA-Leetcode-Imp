// Given an integer n, return true if it is a power of two. Otherwise, return false.

//  An integer n is a power of two, if there exists an integer x such that n == 2x.

public class Solution {
    public boolean isPowerOfTwo(int n) {
        // A power of two has exactly one '1' bit in binary form
        return n > 0 && (n & (n - 1)) == 0;
    }
}
