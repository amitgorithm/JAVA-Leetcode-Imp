/* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

3 <= nums.length <= 3000
-105 <= nums[i] <= 105*/



import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to enable two-pointer strategy
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int a = nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;

                if (sum == 0) {
                    res.add(Arrays.asList(a, b, c));
                    // Skip duplicates for b and c
                    while (left < right && nums[left] == b) left++;
                    while (left < right && nums[right] == c) right--;
                } else if (sum < 0) {
                    left++;  // Need a bigger number
                } else {
                    right--;  // Need a smaller number
                }
            }
        }

        return res;
    }
}
