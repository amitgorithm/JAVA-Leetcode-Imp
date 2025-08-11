/* 
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

*/
import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        
        // Effective shifts
        k = k % total;
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Flatten 2D grid to 1D array
        int[] flat = new int[total];
        int index = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flat[index++] = val;
            }
        }
        
        // Create shifted version
        int[] shifted = new int[total];
        for (int i = 0; i < total; i++) {
            shifted[(i + k) % total] = flat[i];
        }
        
        // Convert back to 2D List<List<Integer>>
        index = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(shifted[index++]);
            }
            result.add(row);
        }
        
        return result;
    }
}
