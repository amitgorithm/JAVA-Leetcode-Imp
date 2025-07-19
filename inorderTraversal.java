/* 
Given the root of a binary tree, return the inorder traversal of its nodes' values.
Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }
}
