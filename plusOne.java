// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

// Increment the large integer by one and return the resulting array of digits.  

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and process carry if needed
        for (int i = n - 1; i >= 0; i--) {
            // If digit is less than 9, just add one and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit is 9, set to 0 and continue to propagate carry
            digits[i] = 0;
        }

        // If we reached here, all digits were 9 -> result is 100...0
        int[] result = new int[n + 1];
        result[0] = 1; // All others are already 0 by default
        return result;
    }
}
