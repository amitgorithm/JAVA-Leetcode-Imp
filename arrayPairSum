/* Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum. */


import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);  // Sort the array to pair smallest numbers together
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];  // Add every first element in each pair
        }
        return sum;
    }
}
