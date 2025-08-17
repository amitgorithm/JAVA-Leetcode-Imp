/* Given an integer array arr and a filtering function fn, return a filtered array filteredArr.

The fn function takes one or two arguments:

arr[i] - number from the arr

i - index of arr[i]

filteredArr should only contain the elements from the arr for which the expression fn(arr[i], i) evaluates to a truthy value. A truthy value is a value where Boolean(value) returns true.

Please solve it without the built-in Array.filter method. */

/**
 * Given an integer array arr and a filtering function fn, return a new filtered array.
 * The fn function takes one or two arguments:
 * - arr[i]: The element from the array.
 * - i: The index of the element.
 *
 * The new array should only contain elements for which fn(arr[i], i)
 * evaluates to a truthy value.
 *
 * @param {number[]} arr The input array of numbers.
 * @param {Function} fn The filtering function.
 * @return {number[]} The new, filtered array.
 */
var filter = function(arr, fn) {
  // Create an empty array to store the filtered elements.
  const filteredArr = [];

  // Iterate over the input array using a standard for loop.
  for (let i = 0; i < arr.length; i++) {
    // Call the provided filtering function 'fn' with the current element and its index.
    const result = fn(arr[i], i);

    // The condition checks if the result of the function call is "truthy".
    // In JavaScript, values like non-empty strings, non-zero numbers, and objects
    // are considered truthy. Values like 0, '', null, undefined, NaN, and false are falsy.
    if (result) {
      // If the condition is truthy, push the current element into the new array.
      filteredArr.push(arr[i]);
    }
  }

  // Return the new array containing only the elements that passed the filter.
  return filteredArr;
};

/**
 * Example Usage:
 *
 * // Example 1: Filter for numbers greater than 10.
 * const arr1 = [0, 10, 20, 30];
 * const greaterThan10 = function(n) { return n > 10; };
 * const result1 = filter(arr1, greaterThan10);
 * console.log(result1); // [20, 30]
 *
 * // Example 2: Filter for elements at even indices.
 * const arr2 = [1, 2, 3, 4, 5];
 * const evenIndex = function(n, i) { return i % 2 === 0; };
 * const result2 = filter(arr2, evenIndex);
 * console.log(result2); // [1, 3, 5]
 *
 * // Example 3: Filter for truthy values (e.g., non-empty strings).
 * const arr3 = ["hello", null, "", "world", 0];
 * const truthyCheck = function(val) { return val; };
 * const result3 = filter(arr3, truthyCheck);
 * console.log(result3); // ["hello", "world"]
 */
