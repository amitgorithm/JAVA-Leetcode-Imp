/** You are given a string s consisting of lowercase English letters ('a' to 'z').

Your task is to:

Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
Find the consonant (all other letters excluding vowels) with the maximum frequency.
Return the sum of the two frequencies.

Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.

The frequency of a letter x is the number of times it occurs in the string. 
**/

/**
 * @param {string} s
 * @return {number}
 */
var maxFreqSum = function(s) {
    const vowels = new Set(['a','e','i','o','u']);
    const freq = new Array(26).fill(0);

    for (const ch of s) {
        freq[ch.charCodeAt(0) - 97]++;
    }

    let maxV = 0, maxC = 0;
    for (let i = 0; i < 26; i++) {
        const count = freq[i];
        const ch = String.fromCharCode(97 + i);
        if (vowels.has(ch)) {
            maxV = Math.max(maxV, count);
        } else {
            maxC = Math.max(maxC, count);
        }
    }
    return maxV + maxC;
};
