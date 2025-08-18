/* Given an array arr and a chunk size size, return a chunked array.

A chunked array contains the original elements in arr, but consists of subarrays each of length size. The length of the last subarray may be less than size if arr.length is not evenly divisible by size.

Please solve it without using lodash's _.chunk function. */

var chunk = function(arr, size) {
  // Create an empty array to hold the chunked subarrays.
  const chunkedArr = [];

  // Iterate through the original array. We increment by `size`
  // in each step to jump to the start of the next chunk.
  for (let i = 0; i < arr.length; i += size) {
    // The `slice()` method extracts a portion of the array from the
    // current index `i` up to `i + size` and returns a new array.
    // This is a clean way to create each chunk.
    const chunk = arr.slice(i, i + size);
    
    // Add the new chunk (subarray) to our result array.
    chunkedArr.push(chunk);
  }

  // Return the final chunked array.
  return chunkedArr;
};
