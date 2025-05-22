//  Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.

class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            // If current is closer to 0
            if (Math.abs(current) < Math.abs(closest)) {
                closest = current;
            }
            // If equally close, prefer the larger value
            else if (Math.abs(current) == Math.abs(closest) && current > closest) {
                closest = current;
            }
        }
        
        return closest;
    }
}
