/*  Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1. */


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int sum=0,max=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return max;
        
    }
}
