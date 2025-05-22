// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

import java.util.*;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
            lastIndex.put(num, i);
        }

        int degree = Collections.max(freq.values());
        int minLength = nums.length;

        for (int num : freq.keySet()) {
            if (freq.get(num) == degree) {
                int length = lastIndex.get(num) - firstIndex.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }
}
