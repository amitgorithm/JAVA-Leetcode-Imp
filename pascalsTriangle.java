/* Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); // First element is always 1

            for (int col = 1; col < row; col++) {
                int val = triangle.get(row - 1).get(col - 1) + triangle.get(row - 1).get(col);
                currentRow.add(val);
            }

            if (row > 0) {
                currentRow.add(1); // Last element is 1 if row index > 0
            }

            triangle.add(currentRow);
        }

        return triangle;
    }
}
