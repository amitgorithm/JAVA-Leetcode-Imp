/* 
You are given an m x n matrix mat that has its rows sorted in non-decreasing order and an integer k.

You are allowed to choose exactly one element from each row to form an array.

Return the kth smallest array sum among all possible arrays.

constraints: 

m == mat.length
n == mat.length[i]
1 <= m, n <= 40
1 <= mat[i][j] <= 5000
1 <= k <= min(200, nm)
mat[i] is a non-decreasing array.
  */




import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        Set<String> visited = new HashSet<>();

        int[] initial = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += mat[i][0];
        }

        pq.offer(new Node(initial, sum));
        visited.add(Arrays.toString(initial));

        while (--k > 0) {
            Node node = pq.poll();

            for (int i = 0; i < m; i++) {
                if (node.indices[i] + 1 < n) {
                    int[] next = Arrays.copyOf(node.indices, m);
                    next[i]++;
                    int newSum = node.sum - mat[i][node.indices[i]] + mat[i][next[i]];
                    String key = Arrays.toString(next);

                    if (!visited.contains(key)) {
                        visited.add(key);
                        pq.offer(new Node(next, newSum));
                    }
                }
            }
        }

        return pq.peek().sum;
    }

    class Node {
        int[] indices;
        int sum;

        Node(int[] indices, int sum) {
            this.indices = indices;
            this.sum = sum;
        }
    }
}
