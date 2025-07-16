/* The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.
Constraints:

1 <= n <= 30 
*/

class Solution {
    public String countAndSayIterative(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        String res = "";
        int i = 0;
        while (i < prev.length()) {
            char ch = prev.charAt(i);
            int cnt = 1;
            int j = i + 1;
            while (j < prev.length() && prev.charAt(j) == ch) {
                cnt++;
                j++;
            }
            res = res + cnt + ch;
            i = j;
        }
        return res;
    }
}
