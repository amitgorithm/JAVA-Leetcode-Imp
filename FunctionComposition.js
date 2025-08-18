/* Given an array of functions [f1, f2, f3, ..., fn], return a new function fn that is the function composition of the array of functions.

The function composition of [f(x), g(x), h(x)] is fn(x) = f(g(h(x))).

The function composition of an empty list of functions is the identity function f(x) = x.

You may assume each function in the array accepts one integer as input and returns one integer as output. */


var compose = function(functions) {
  // If the input array is empty, the composed function is the identity function.
  // The identity function simply returns its input.
  if (functions.length === 0) {
    return x => x;
  }

  // The core of the composition is to apply the functions from right to left.
  // We can achieve this by manually iterating through the array in reverse order.
  return function(x) {
    let result = x;
    for (let i = functions.length - 1; i >= 0; i--) {
      // In each iteration, the current function (from right to left)
      // is applied to the result of the previous function call.
      // This correctly builds the f(g(h(x))) chain.
      result = functions[i](result);
    }
    return result;
  };
};


