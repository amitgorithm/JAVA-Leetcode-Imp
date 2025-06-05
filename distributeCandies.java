/* You are given two positive integers n and limit.

Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies. */




class Solution {
    public long distributeCandies(int n, int limit) {
        long total = combination(n + 2, 2);

        // Subtract cases where one child exceeds limit
        for (int i = 0; i < 3; i++) {
            int rem = n - (limit + 1);
            if (rem >= 0) {
                total -= combination(rem + 2, 2);
            }
        }

        // Add back cases where two children exceed limit
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                int rem = n - 2 * (limit + 1);
                if (rem >= 0) {
                    total += combination(rem + 2, 2);
                }
            }
        }

        // Subtract cases where all three exceed limit
        int rem = n - 3 * (limit + 1);
        if (rem >= 0) {
            total -= combination(rem + 2, 2);
        }

        return total;
    }

    private long combination(int n, int r) {
        if (n < r) return 0;
        return ((long) n * (n - 1)) / 2;
    }
}
