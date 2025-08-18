/* Given a multi-dimensional array of integers, return a generator object which yields integers in the same order as inorder traversal.

A multi-dimensional array is a recursive data structure that contains both integers and other multi-dimensional arrays.

inorder traversal iterates over each array from left to right, yielding any integers it encounters or applying inorder traversal to any arrays it encounters. */

function* inorderTraversal(arr) {
  // Iterate through each element of the input array.
  for (const element of arr) {
    // Check if the current element is a number.
    if (typeof element === 'number') {
      // If it's a number, yield it. The generator pauses here until the next() call.
      yield element;
    } else if (Array.isArray(element)) {
      // If the element is another array, delegate to a new instance of the same generator.
      // `yield*` effectively iterates through the inner generator and yields each value from it.
      yield* inorderTraversal(element);
    }
  }
}
