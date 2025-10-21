# Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

# In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

# Example 1:

# Input: rowIndex = 3
# Output: [1,3,3,1]

class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        row = [1]
        for i in range(rowIndex):
            row = [1] + [row[j] + row[j + 1] for j in range(len(row) - 1)] + [1]
        return row
