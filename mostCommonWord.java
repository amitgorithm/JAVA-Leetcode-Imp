/* Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Note that words can not contain punctuation symbols.

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters. */

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Convert banned list into a set for fast lookup
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        // Normalize paragraph: remove punctuation, convert to lowercase
        paragraph = paragraph.replaceAll("[!?',;\\.]", " ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
        }
        
        // Find the word with the highest frequency
        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
