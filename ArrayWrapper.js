/* Create a class ArrayWrapper that accepts an array of integers in its constructor. This class should have two features:

When two instances of this class are added together with the + operator, the resulting value is the sum of all the elements in both arrays.

When the String() function is called on the instance, it will return a comma separated string surrounded by brackets. For example, [1,2,3]. */

class ArrayWrapper {
  /**
   * Constructs an ArrayWrapper instance.
   * @param {number[]} nums The array of integers.
   */
  constructor(nums) {
    this.nums = nums;
  }

  /**
   * Overrides the `valueOf` method to define how the instance is handled in numeric contexts.
   * This method is automatically called when the `+` operator is used with an ArrayWrapper instance.
   * It returns the sum of all elements in the internal array.
   * @return {number} The sum of the elements.
   */
  valueOf() {
    let sum = 0;
    // Iterate through the internal array and calculate the sum of its elements.
    for (const num of this.nums) {
      sum += num;
    }
    return sum;
  }

  /**
   * Overrides the `toString` method to define the string representation of the instance.
   * This method is automatically called when the `String()` function is used on the instance.
   * It returns a string in the format "[1,2,3]".
   * @return {string} The string representation of the array.
   */
  toString() {
    // We can use a template literal and `join` to format the string.
    return `[${this.nums.join(',')}]`;
  }
}
