/** No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

Given an integer n, return a list of two integers [a, b] where:

a and b are No-Zero integers.
a + b = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.
**/

/**
 * @param {number} n
 * @return {number[]}
 */
var getNoZeroIntegers = function(n) {
    // helper function to check if a number contains '0'
    function hasZero(x) {
        return x.toString().includes('0');
    }

    for (let a = 1; a < n; a++) {
        let b = n - a;
        if (!hasZero(a) && !hasZero(b)) {
            return [a, b];
        }
    }
    return []; // fallback, though problem guarantees a solution
};
