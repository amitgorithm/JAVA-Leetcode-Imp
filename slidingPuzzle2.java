/** On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it. The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]]. Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
**/

import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int v : row) sb.append(v);
        }
        String start = sb.toString();
        String target = "123450";
        
        int[][] neighbors = {
            {1, 3},        // index 0
            {0, 2, 4},     // index 1
            {1, 5},        // index 2
            {0, 4},        // index 3
            {1, 3, 5},     // index 4
            {2, 4}         // index 5
        };
        
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.offer(start);
        seen.add(start);
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) return steps;
                int zero = cur.indexOf('0');
                for (int nei : neighbors[zero]) {
                    char[] arr = cur.toCharArray();
                    char tmp = arr[zero];
                    arr[zero] = arr[nei];
                    arr[nei] = tmp;
                    String nxt = new String(arr);
                    if (!seen.contains(nxt)) {
                        seen.add(nxt);
                        q.offer(nxt);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
