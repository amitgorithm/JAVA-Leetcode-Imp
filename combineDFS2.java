/ ** 
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n]. You may return the answer in any order.
**/


import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int start, int n, int k, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(i + 1, n, k, path, res);
            path.remove(path.size() - 1);
        }
    }
}
