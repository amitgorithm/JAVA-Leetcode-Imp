// Given a 32-bit integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

// All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

//  Note: You are not allowed to use any built-in library method to directly solve this problem.

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder hex = new StringBuilder();

        // Use unsigned right shift to handle negative numbers
        while (num != 0 && hex.length() < 8) {
            int digit = num & 0xf; // Extract last 4 bits
            hex.append(hexChars[digit]);
            num >>>= 4; // Unsigned right shift by 4
        }

        return hex.reverse().toString();
    }
}
