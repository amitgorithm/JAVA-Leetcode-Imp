/* Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices. */

import java.util.*;

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        if (x == j && y == i) {
                            result[x][y] = matrix[i][j];
                        }
                    }
                }
            }
        }

        return result;
    }
}
