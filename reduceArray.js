/* Given an integer array nums, a reducer function fn, and an initial value init, return the final result obtained by executing the fn function on each element of the array, sequentially, passing in the return value from the calculation on the preceding element.

This result is achieved through the following operations: val = fn(init, nums[0]), val = fn(val, nums[1]), val = fn(val, nums[2]), ... until every element in the array has been processed. The ultimate value of val is then returned.

If the length of the array is 0, the function should return init.

Please solve it without using the built-in Array.reduce method. */

/**
 * Given an integer array nums, a reducer function fn, and an initial value init,
 * return the final result obtained by executing the fn function on each element
 * of the array, sequentially, passing in the return value from the calculation
 * on the preceding element.
 *
 * @param {number[]} nums The input array of numbers.
 * @param {Function} fn The reducer function.
 * @param {number} init The initial value.
 * @return {number} The final reduced value.
 */
var reduce = function(nums, fn, init) {
  let val = init;
  for (let i = 0; i < nums.length; i++) {
    val = fn(val, nums[i]);
  }
  return val;
};

/**
 * Example Usage:
 *
 * // Example 1: Sum all numbers in the array.
 * const nums1 = [1, 2, 3, 4];
 * const sumFn = function(accum, curr) { return accum + curr; };
 * const result1 = reduce(nums1, sumFn, 0);
 * console.log(result1); // 10
 *
 * // Example 2: Sum with an initial value.
 * const nums2 = [1, 2, 3, 4];
 * const sumFnWithInit = function(accum, curr) { return accum + curr; };
 * const result2 = reduce(nums2, sumFnWithInit, 100);
 * console.log(result2); // 110
 *
 * // Example 3: Handle an empty array.
 * const nums3 = [];
 * const result3 = reduce(nums3, sumFn, 0);
 * console.log(result3); // 0
 */
