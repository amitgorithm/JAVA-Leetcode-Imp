/* A word is considered valid if:

It contains a minimum of 3 characters.
It contains only digits (0-9), and English letters (uppercase and lowercase).
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.

Return true if word is valid, otherwise, return false.

Notes:

'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
A consonant is an English letter that is not a vowel.
Constraints:

1 <= word.length <= 20
word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'. */

class Solution {
    public boolean isValid(String w) {
        if (w.length() < 3) return false;

        boolean v = false, c = false;

        for (char ch : w.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) return false;

            if (Character.isLetter(ch)) {
                char l = Character.toLowerCase(ch);
                if ("aeiou".indexOf(l) >= 0) {
                    v = true;
                } else {
                    c = true;
                }
            }
        }

        return v && c;
    }
}
