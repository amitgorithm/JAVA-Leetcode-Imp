/* An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise. */

/* brute force approach : */
// class Solution {
//     public boolean isMonotonic(int[] a) {
//         boolean inc = true;
//         boolean dec = true;

//         for (int i = 0; i < a.length; i++) {
//             for (int j = i + 1; j < a.length; j++) {
//                 if (a[i] > a[j]) inc = false;
//                 if (a[i] < a[j]) dec = false;
//             }
//         }

//         return inc || dec;
//     }
// }

// optimised approach:
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dec = false;
            if (nums[i] < nums[i - 1]) inc = false;
        }

        return inc || dec;
    }
}
