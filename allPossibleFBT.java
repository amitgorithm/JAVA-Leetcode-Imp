/** Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children. **/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        
        return solve(n);
        
    }
    public List<TreeNode> solve(int n){

    ArrayList<TreeNode> list=new ArrayList<>();
        if(n==1){
            TreeNode node=new TreeNode(0);
            list.add(node);
            return list;
        }
        if(n%2==0){
            return list;
        }

      
        for(int i=1; i<n; i=i+2){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(n-i-1);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node=new TreeNode(0);
                    node.left=l;
                    node.right=r;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
