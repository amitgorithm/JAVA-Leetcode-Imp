/* Given a function fn and a time in milliseconds t, return a debounced version of that function.

A debounced function is a function whose execution is delayed by t milliseconds and whose execution is cancelled if it is called again within that window of time. The debounced function should also receive the passed parameters.

For example, let's say t = 50ms, and the function was called at 30ms, 60ms, and 100ms.

The first 2 function calls would be cancelled, and the 3rd function call would be executed at 150ms.

If instead t = 35ms, The 1st call would be cancelled, the 2nd would be executed at 95ms, and the 3rd would be executed at 135ms.



The above diagram shows how debounce will transform events. Each rectangle represents 100ms and the debounce time is 400ms. Each color represents a different set of inputs.

Please solve it without using lodash's _.debounce() function. */

/**
 * Given a function `fn` and a time `t` in milliseconds, return a debounced version of that function.
 *
 * @param {Function} fn The function to be debounced.
 * @param {number} t The debounce time in milliseconds.
 * @return {Function} A new debounced function.
 */
var debounce = function(fn, t) {
  // `timeoutId` will store the ID of the timer created by `setTimeout`.
  // This variable is part of the closure and will persist across calls to the debounced function.
  let timeoutId;

  // The debounced function is what is returned to the user.
  // It accepts any number of arguments and passes them to the original function `fn`.
  return function(...args) {
    // Before creating a new timer, clear the previous one if it exists.
    // This is the core of the debounce logic: cancelling the previous execution
    // if the function is called again within the specified time window.
    clearTimeout(timeoutId);

    // Set a new timer. After `t` milliseconds, the provided `fn` will be executed.
    // We use an arrow function to preserve the `this` context and capture the arguments.
    timeoutId = setTimeout(() => {
      // Use `apply` to call `fn` with the correct `this` context and the arguments.
      // This ensures `fn` behaves as expected, regardless of how the debounced function is called.
      fn.apply(this, args);
    }, t);
  };
};

/**
 * Example Usage:
 *
 * // Create a function that logs a message.
 * const logMessage = (msg) => console.log(`Logged: ${msg}`);
 *
 * // Create a debounced version of the function with a delay of 500ms.
 * const debouncedLog = debounce(logMessage, 500);
 *
 * // Example 1: Call multiple times in quick succession.
 * // The last call will be executed after a 500ms delay.
 * console.log("Calling debouncedLog multiple times...");
 * debouncedLog("First call");
 * debouncedLog("Second call"); // This cancels the first one.
 * debouncedLog("Third call");  // This cancels the second one.
 *
 * setTimeout(() => {
 * console.log("\nCalling after a short delay...");
 * debouncedLog("Fourth call (should log after 500ms)"); // This call is separate.
 * }, 700);
 *
 * // Expected Output:
 * // Calling debouncedLog multiple times...
 * // ... (500ms delay) ...
 * // Logged: Third call
 * //
 * // Calling after a short delay...
 * // ... (500ms delay) ...
 * // Logged: Fourth call (should log after 500ms)
 *
 * // You can test with the provided LeetCode examples by replacing the calls.
 */
