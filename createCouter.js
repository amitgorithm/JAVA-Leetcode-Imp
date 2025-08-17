/* Given an integer n, return a counter function. This counter function initially returns n and then returns 1 more than the previous value every subsequent time it is called (n, n + 1, n + 2, etc). */
/**
 * Given an integer n, return a counter function.
 * This counter function initially returns n and then returns 1 more than the previous value
 * every subsequent time it is called (n, n + 1, n + 2, etc).
 *
 * @param {number} n The initial value for the counter.
 * @return {Function} The counter function.
 */
var createCounter = function(n) {
  // The returned function forms a closure over the 'n' variable from its outer scope.
  // This means it "remembers" the value of 'n' even after createCounter has finished executing.
  return function() {
    // We use the post-increment operator (n++).
    // This returns the current value of 'n' and then increments it for the next call.
    // So the first call returns the original n, the second returns n+1, and so on.
    return n++;
  };
};

/**
 * Example Usage:
 *
 * const counter = createCounter(10);
 * console.log(counter()); // 10
 * console.log(counter()); // 11
 * console.log(counter()); // 12
 *
 * const anotherCounter = createCounter(5);
 * console.log(anotherCounter()); // 5
 * console.log(anotherCounter()); // 6
 */
