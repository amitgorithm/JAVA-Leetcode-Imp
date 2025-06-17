/* Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

3 <= nums.length <= 104
1 <= nums[i] <= 106 */


import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums); // Sort in ascending order
        
        // Try the largest 3 sides first, moving down
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i], b = nums[i - 1], c = nums[i - 2];
            if (b + c > a) {
                return a + b + c; // Valid triangle
            }
        }
        
        return 0; // No valid triangle found
    }
}
