/** Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it. If the tree has more than one mode, return them in any order. Assume a BST is defined as follows: The left subtree of a node contains only nodes with keys less than or equal to the node's key. The right subtree of a node contains only nodes with keys greater than or equal to the node's key. Both the left and right subtrees must also be binary search trees. Example 1: Input: root = [1,null,2,2] Output: [2]
**/

import java.util.*;

class Solution {
    private Integer prev = null;
    private int count = 0;
    private int max = 0;
    private List<Integer> res = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        
        if (prev == null || node.val != prev) {
            count = 1;
        } else {
            count++;
        }
        
        if (count > max) {
            max = count;
            res.clear();
            res.add(node.val);
        } else if (count == max) {
            res.add(node.val);
        }
        
        prev = node.val;
        
        inorder(node.right);
    }
}
