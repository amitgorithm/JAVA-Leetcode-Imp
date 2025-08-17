/* Given a positive integer millis, write an asynchronous function that sleeps for millis milliseconds. It can resolve any value.

Note that minor deviation from millis in the actual sleep duration is acceptable. */

/**
 * Given a positive integer millis, write an asynchronous function that sleeps for
 * millis milliseconds. It can resolve any value.
 *
 * @param {number} millis The number of milliseconds to sleep.
 * @return {Promise<void>} A Promise that resolves after the specified duration.
 */
async function sleep(millis) {
  // This function uses a Promise to handle the asynchronous nature of the "sleep" operation.
  // It returns a new Promise that will resolve when the sleep duration is complete.
  return new Promise(resolve => {
    // The setTimeout function is used to schedule the resolve() callback.
    // After `millis` milliseconds have passed, the Promise is fulfilled.
    setTimeout(() => {
      // Calling resolve() fulfills the Promise, allowing the `await` expression to continue.
      // We don't need to pass a value to resolve(), as the problem states it can resolve any value.
      resolve();
    }, millis);
  });
}

/**
 * Example Usage:
 *
 * async function main() {
 * // Log a message, then call the sleep function with `await` to pause execution.
 * console.log('Starting the sleep...');
 *
 * // The program execution will pause here for 2000 milliseconds (2 seconds).
 * await sleep(2000);
 *
 * // This message will only be logged after the sleep duration is over.
 * console.log('...Finished sleeping!');
 * }
 *
 * // Call the main function to start the asynchronous process.
 * main();
 */
