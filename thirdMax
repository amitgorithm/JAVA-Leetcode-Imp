// Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

import java.util.TreeSet;

public class Solution {
    /**
     * Constraints:
     * 1 <= nums.length <= 10^4
     * -2^31 <= nums[i] <= 2^31 - 1
     */
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a); // descending order

        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollLast(); // keep only top 3 max elements
            }
        }

        if (set.size() < 3) {
            return set.first(); // return max if third max doesn't exist
        }

        return set.last(); // return third max
    }
}
