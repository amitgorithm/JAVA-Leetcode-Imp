/* Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1 */

import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        // Use a TreeSet to keep distinct numbers in descending order
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        
        for (int num : nums) {
            set.add(num);
        }

        // If there are fewer than 3 distinct elements, return the max
        if (set.size() < 3) {
            return set.first();
        }

        // Otherwise, get the third maximum
        Iterator<Integer> iterator = set.iterator();
        iterator.next(); // first max
        iterator.next(); // second max
        return iterator.next(); // third max
    }
}
