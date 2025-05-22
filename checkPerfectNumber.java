// A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

// Given an integer n, return true if n is a perfect number, otherwise return false.

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = 1; // 1 is always a divisor (except for 1 itself)
        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                int otherDivisor = num / i;
                if (otherDivisor != i) {
                    sum += otherDivisor;
                }
            }
        }

        return sum == num;
    }
}
