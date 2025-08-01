/* You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.

In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.

Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.

Each answer[i] is calculated considering the initial state of the boxes.
Constraints:

n == boxes.length
1 <= n <= 2000
boxes[i] is either '0' or '1'. */


class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] minimumOperations = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (boxes.charAt(j) == '0')
                    continue;
                minimumOperations[i] += Math.abs(j - i);
            }
        }
        return minimumOperations;
    }
}
