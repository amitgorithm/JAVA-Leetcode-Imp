// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;  // ways to climb 1 step
        int second = 2; // ways to climb 2 steps

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}


/* Input: n = 2
Output: 2
Explanation: 1+1 or 2

Input: n = 3
Output: 3
Explanation: (1+1+1), (1+2), (2+1) */
