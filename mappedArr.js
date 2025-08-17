/* Given an integer array arr and a mapping function fn, return a new array with a transformation applied to each element.

The returned array should be created such that returnedArray[i] = fn(arr[i], i).

Please solve it without the built-in Array.map method. */

var map = function(arr, fn) {
  // Create an empty array to store the transformed elements.
  const mappedArr = [];

  // Iterate over the input array using a standard for loop.
  for (let i = 0; i < arr.length; i++) {
    // Call the provided mapping function 'fn' with the current element and its index.
    const transformedValue = fn(arr[i], i);

    // Push the result of the transformation into the new array.
    mappedArr.push(transformedValue);
  }

  // Return the new array containing the transformed elements.
  return mappedArr;
};
