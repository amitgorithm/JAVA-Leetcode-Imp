// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

import java.util.HashMap;

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // The problem guarantees one solution, so this should never be reached
        throw new IllegalArgumentException("No two sum solution found");
    }

    // Example usage
    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
