// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. //

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Duplicate found
            }
            seen.add(num);
        }

        return false; // All elements are distinct
    }
}
