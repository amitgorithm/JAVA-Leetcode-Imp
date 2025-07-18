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
