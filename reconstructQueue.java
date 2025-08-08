/* You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
*/

import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Step 1: Sort by height (descending), and if height equal, by k (ascending)
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // Higher height first
            } else {
                return a[1] - b[1]; // Lower k first
            }
        });

        // Step 2: Use LinkedList to insert people in correct position
        List<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }

        // Step 3: Convert back to array
        return queue.toArray(new int[people.length][]);
    }

    // Test the program
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = sol.reconstructQueue(people);

        for (int[] p : result) {
            System.out.println(Arrays.toString(p));
        }
    }
}
