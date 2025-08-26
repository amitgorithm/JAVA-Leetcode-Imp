/* Given a function fn, return a new function that is identical to the original function except that it ensures fn is called at most once.

The first time the returned function is called, it should return the same result as fn.

Every subsequent time it is called, it should return undefined. */

var once = function(fn) {
  // `hasBeenCalled` is a boolean flag to track the function's call status.
  // It's part of the closure, so its state persists across multiple calls to the returned function.
  let hasBeenCalled = false;
  // `result` will store the return value of the first successful call to `fn`.
  let result;

  // We return a new function that takes any number of arguments.
  return function(...args) {
    // We check if the function has been called before.
    if (!hasBeenCalled) {
      // If not, we set the flag to true.
      hasBeenCalled = true;
      // We call the original function with the given arguments and store its result.
      result = fn(...args);
      // We return the result of the first call.
      return result;
    } else {
      // If the function has already been called, return the stored result.
      return undefined;
    }
  };
};
