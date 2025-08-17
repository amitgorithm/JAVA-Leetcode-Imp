/* Write code that enhances all arrays such that you can call the array.last() method on any array and it will return the last element. If there are no elements in the array, it should return -1.

You may assume the array is the output of JSON.parse. */

/**
 * Enhances the Array prototype with a `last()` method.
 * This function returns the last element of the array.
 * If the array is empty, it returns -1.
 * @return {any} The last element of the array, or -1 if the array is empty.
 */
Array.prototype.last = function() {
  // Check if the array is empty.
  // The `this` keyword inside the prototype method refers to the array instance
  // on which the method is called.
  if (this.length === 0) {
    return -1;
  }

  // If the array is not empty, return the last element.
  // The index of the last element is always `length - 1`.
  return this[this.length - 1];
};

/**
 * Example Usage:
 *
 * const arr1 = [1, 2, 3];
 * console.log(arr1.last()); // Should log 3
 *
 * const arr2 = [];
 * console.log(arr2.last()); // Should log -1
 *
 * const arr3 = ['apple', 'banana', 'cherry'];
 * console.log(arr3.last()); // Should log 'cherry'
 *
 * // Note: LeetCode's environment will test this solution with various inputs
 * // and will not require these console logs.
 */
