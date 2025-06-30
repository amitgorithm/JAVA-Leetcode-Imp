/* Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // in case k > n

        // Step 1: reverse the whole array
        reverse(nums, 0, n - 1);

        // Step 2: reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
