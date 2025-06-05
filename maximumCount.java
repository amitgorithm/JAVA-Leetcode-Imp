/* You are given an integer array nums having length n and a 2D integer array queries where queries[i] = [idx, val].

For each query:

Update nums[idx] = val.
Choose an integer k with 1 <= k < n to split the array into the non-empty prefix nums[0..k-1] and suffix nums[k..n-1] such that the sum of the counts of distinct prime values in each part is maximum.
Note: The changes made to the array in one query persist into the next query.

Return an array containing the result for each query, in the order they are given.

 

Example 1:

Input: nums = [2,1,3,1,2], queries = [[1,2],[3,3]]

Output: [3,4]

Explanation:

Initially nums = [2, 1, 3, 1, 2].
After 1st query, nums = [2, 2, 3, 1, 2]. Split nums into [2] and [2, 3, 1, 2]. [2] consists of 1 distinct prime and [2, 3, 1, 2] consists of 2 distinct primes. Hence, the answer for this query is 1 + 2 = 3.
After 2nd query, nums = [2, 2, 3, 3, 2]. Split nums into [2, 2, 3] and [3, 2] with an answer of 2 + 2 = 4.
The output is [3, 4]. */




import java.util.*;

class Solution {

    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int[] maximumCount(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] result = new int[q];

        for (int qi = 0; qi < q; qi++) {
            int idx = queries[qi][0], val = queries[qi][1];
            nums[idx] = val;

            int max = 0;

            for (int k = 1; k < n; k++) {
                Set<Integer> left = new HashSet<>();
                Set<Integer> right = new HashSet<>();

                for (int i = 0; i < k; i++) {
                    if (isPrime(nums[i])) left.add(nums[i]);
                }

                for (int i = k; i < n; i++) {
                    if (isPrime(nums[i])) right.add(nums[i]);
                }

                max = Math.max(max, left.size() + right.size());
            }

            result[qi] = max;
        }

        return result;
    }
}
