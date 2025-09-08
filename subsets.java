/** Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order. **/ 


import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        build(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void build(int[] arr, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (idx == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // include
        curr.add(arr[idx]);
        build(arr, idx + 1, curr, res);
        curr.remove(curr.size() - 1);

        // exclude
        build(arr, idx + 1, curr, res);
    }
}
