// You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

// Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
// Constraints:

// 2 <= letters.length <= 104
//  letters[i] is a lowercase English letter.
// letters is sorted in non-decreasing order.
// letters contains at least two different characters.
// target is a lowercase English letter. //

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid character is less than or equal to target, discard left half
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If no character is greater than target, wrap around to letters[0]
        return letters[low % letters.length];
    }
}
