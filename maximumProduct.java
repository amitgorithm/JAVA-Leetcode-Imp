// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

// Constraints:

// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000 //

import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums); // Sort the array

        int n = nums.length;

        // Option 1: Product of three largest numbers
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Option 2: Product of two smallest and the largest number
        int option2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(option1, option2);
    }
}
