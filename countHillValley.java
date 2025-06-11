/* You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]. Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]. Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].

Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.

Return the number of hills and valleys in nums. */

class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;

            // Skip equal elements to the left
            while (left >= 0 && nums[left] == nums[i]) {
                left--;
            }

            // Skip equal elements to the right
            while (right < nums.length && nums[right] == nums[i]) {
                right++;
            }

            if (left >= 0 && right < nums.length) {
                if (nums[i] > nums[left] && nums[i] > nums[right]) {
                    count++; // hill
                } else if (nums[i] < nums[left] && nums[i] < nums[right]) {
                    count++; // valley
                }
            }
        }
        return count;
    }
}
