//  Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

// using math

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}

// alternate using XOR
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n;

        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }

        return xor;
    }
}
