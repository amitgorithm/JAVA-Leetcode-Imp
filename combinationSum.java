/* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40 */

class Solution {
    public void helper(List<List<Integer>> mainlist,List<Integer> list,int[] candidates, int target,int index,int curr)
    {
        if(target==0){
            mainlist.add(new ArrayList<>(list));
            return;
        }
        if(target<0) return;

        for(int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            helper(mainlist,list,candidates,target-candidates[i],i,curr);
            list.remove(list.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> mainlist = new ArrayList<>();
        if(target<candidates[0]){
            return mainlist;
        }
        helper(mainlist,new ArrayList<>(),candidates,target,0,candidates[0]);
        return mainlist;
    }
}
