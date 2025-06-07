/* You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.

1 <= words.length <= 100
1 <= words[i].length, pref.length <= 100
words[i] and pref consist of lowercase English letters. */

class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
