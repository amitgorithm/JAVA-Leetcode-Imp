// Given an integer array nums, return the most frequent even element.

// If there is a tie, return the smallest one. If there is no such element, return -1.

class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] freq = new int[100001];  // constraint: -10^5 <= nums[i] <= 10^5
        int maxFreq = 0;
        int result = -1;

        for (int num : nums) {
            if (num % 2 == 0) {
                freq[num]++;
                if (freq[num] > maxFreq) {
                    maxFreq = freq[num];
                    result = num;
                } else if (freq[num] == maxFreq && num < result) {
                    result = num;
                }
            }
        }

        return result;
    }
}
