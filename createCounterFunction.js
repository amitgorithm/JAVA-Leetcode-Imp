/* Write a function createCounter. It should accept an initial integer init. It should return an object with three functions.

The three functions are:

increment() increases the current value by 1 and then returns it.

decrement() reduces the current value by 1 and then returns it.

reset() sets the current value to init and then returns it. */

/**
 * A function that creates a counter object with methods to increment, decrement, and reset its value.
 * The counter object maintains its state through a closure.
 *
 * @param {number} init The initial value for the counter.
 * @return {Object} An object containing the three counter methods.
 */
var createCounter = function(init) {
  // A variable to store the current value of the counter.
  // This variable is part of a closure, meaning it is accessible to
  // the functions defined within this scope and will persist across calls.
  let currentValue = init;

  // Return an object that exposes the three methods.
  return {
    /**
     * Increases the current value by 1 and then returns it.
     * @return {number} The new, incremented value.
     */
    increment: function() {
      // The prefix increment operator increases the value and then returns it.
      return ++currentValue;
    },

    /**
     * Reduces the current value by 1 and then returns it.
     * @return {number} The new, decremented value.
     */
    decrement: function() {
      // The prefix decrement operator reduces the value and then returns it.
      return --currentValue;
    },

    /**
     * Sets the current value back to the initial value and then returns it.
     * @return {number} The reset value.
     */
    reset: function() {
      // The value is reset to the initial value from the closure.
      currentValue = init;
      return currentValue;
    }
  };
};

/**
 * Example Usage:
 *
 * // Create a new counter object with an initial value of 5.
 * const counter = createCounter(5);
 *
 * console.log(counter.increment()); // logs 6
 * console.log(counter.increment()); // logs 7
 * console.log(counter.decrement()); // logs 6
 * console.log(counter.reset());    // logs 5
 * console.log(counter.increment()); // logs 6
 */
