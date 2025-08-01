// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}


// using hashmaop

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);

            if (count > majorityCount) {
                return num;
            }
        }

        return -1; // Problem guarantees a majority element exists.
    }
}
