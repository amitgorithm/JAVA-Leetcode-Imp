/* Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

*/



class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.right==null && root.left==null) return 1;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        TreeNode tptr=root;
        int depth=0;
        while (que.isEmpty()==false){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode de=que.poll();
                if(de.right!=null) que.add(de.right);
                if(de.left!=null) que.add(de.left);
            }
            depth=depth+1;
        }
        return depth;
    }
}
