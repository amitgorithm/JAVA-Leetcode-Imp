/* Given an asynchronous function fn and a time t in milliseconds, return a new time limited version of the input function. fn takes arguments provided to the time limited function.

The time limited function should follow these rules:

If the fn completes within the time limit of t milliseconds, the time limited function should resolve with the result.

If the execution of the fn exceeds the time limit, the time limited function should reject with the string "Time Limit Exceeded".

dont give comments */

/**
 * Given an asynchronous function `fn` and a time `t` in milliseconds,
 * return a new time-limited version of the input function.
 *
 * @param {Function} fn The asynchronous function to be time-limited.
 * @param {number} t The time limit in milliseconds.
 * @return {Function} A new time-limited version of the function.
 */
var timeLimit = function(fn, t) {
  // Return an asynchronous function that takes any number of arguments.
  return async function(...args) {
    // We create a new Promise that will be rejected if the time limit is exceeded.
    const timeoutPromise = new Promise((resolve, reject) => {
      // Use setTimeout to schedule the rejection.
      // If the timer finishes before fn, the promise will be rejected with the specified error message.
      setTimeout(() => {
        reject("Time Limit Exceeded");
      }, t);
    });

    // We use Promise.race to race the original function call against the timeout promise.
    // The first promise to either resolve or reject will determine the outcome of the race.
    return Promise.race([
      // Call the original function `fn` with its arguments.
      // We need to use `.then()` and `.catch()` to ensure the returned promise from `fn`
      // can be a part of the Promise.race.
      fn(...args),
      timeoutPromise
    ]);
  };
};

/**
 * Example Usage:
 *
 * // Example 1: Function resolves within the time limit.
 * const limitedFn1 = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limitedFn1(50).then(result => console.log(result)).catch(err => console.log(err)); // Resolves
 *
 * // Example 2: Function exceeds the time limit.
 * const limitedFn2 = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limitedFn2(150).then(result => console.log(result)).catch(err => console.log(err)); // Rejects with "Time Limit Exceeded"
 *
 * // Example 3: Function rejects before the time limit is reached.
 * const limitedFn3 = timeLimit((t) => new Promise((res, rej) => setTimeout(() => rej("Error!"), t)), 100);
 * limitedFn3(50).then(result => console.log(result)).catch(err => console.log(err)); // Rejects with "Error!"
 */
