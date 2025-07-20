/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // back tracking
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return ret;
        }
        ArrayList<Integer> curr = new ArrayList<>();
        dfs(nums, ret, curr);
        return ret;
    }
    private static void dfs(int[] nums, List<List<Integer>> ret, ArrayList<Integer> curr){
        if(curr.size() == nums.length){
            ret.add(new ArrayList<Integer>(curr));
        }
        for(int i = 0; i < nums.length; i++){
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                dfs(nums, ret, curr);
                curr.remove(curr.size() - 1);
            } 
        }
    }
}
