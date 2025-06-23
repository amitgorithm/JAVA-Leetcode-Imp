/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order. 
  */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);

        return node;
    }
}
