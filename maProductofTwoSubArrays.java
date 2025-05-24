/* You are given a positive integer n.

Return the maximum product of any two digits in n.

Note: You may use the same digit twice if it appears more than once in n. */

class Solution {
    public int maxProduct(int n) {
        int[] digits = new int[10];

        // Count digit occurrences
        while (n > 0) {
            int d = n % 10;
            digits[d]++;
            n /= 10;
        }

        int maxProduct = 0;

        // Check all combinations
        for (int i = 0; i <= 9; i++) {
            for (int j = i; j <= 9; j++) {
                if ((i == j && digits[i] >= 2) || (i != j && digits[i] > 0 && digits[j] > 0)) {
                    maxProduct = Math.max(maxProduct, i * j);
                }
            }
        }

        return maxProduct;
    }
}
