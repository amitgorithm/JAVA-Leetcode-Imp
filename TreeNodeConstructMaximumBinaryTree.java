/* You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums. */ 

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTreeRecursive(nums, 0, nums.length - 1);
    }

    private TreeNode buildTreeRecursive(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIndex = findMaxIndex(nums, left, right);

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = buildTreeRecursive(nums, left, maxIndex - 1);

        root.right = buildTreeRecursive(nums, maxIndex + 1, right);

        return root;
    }

    private int findMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
