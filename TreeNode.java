/* 
Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0. The rule is similar if the node does not have a right child.
*/

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
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        postOrderSum(root);
        return totalTilt;
    }

    private int postOrderSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = postOrderSum(node.left);
        int rightSum = postOrderSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;
        return node.val + leftSum + rightSum;
    }
}
