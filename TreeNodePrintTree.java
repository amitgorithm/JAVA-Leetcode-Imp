/* construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:

The height of the tree is height and the number of rows m should be equal to height + 1.

The number of columns n should be equal to 2height+1 - 1.

Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).

For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].

Continue this process until all the nodes in the tree have been placed.

Any empty cells should contain the empty string "".

Return the constructed matrix res. */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int rows = height + 1;
        int cols = (1 << (height + 1)) - 1;
        
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(cols, ""));
            res.add(row);
        }
        
        fillMatrix(root, res, 0, (cols - 1) / 2, height);
        
        return res;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    
    private void fillMatrix(TreeNode node, List<List<String>> res, int row, int col, int height) {
        if (node == null) {
            return;
        }
        
        res.get(row).set(col, String.valueOf(node.val));
        
        int offset = 1 << (height - row - 1);
        
        fillMatrix(node.left, res, row + 1, col - offset, height);
        fillMatrix(node.right, res, row + 1, col + offset, height);
    }
}
