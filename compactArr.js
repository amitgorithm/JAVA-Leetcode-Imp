/* Given an object or array obj, return a compact object.

A compact object is the same as the original object, except with keys containing falsy values removed. This operation applies to the object and any nested objects. Arrays are considered objects where the indices are keys. A value is considered falsy when Boolean(value) returns false.

You may assume the obj is the output of JSON.parse. In other words, it is valid JSON. */

var compactObject = function(obj) {
  // Check if the input is null or not a primitive type, excluding null.
  if (obj === null || typeof obj !== 'object') {
    return obj;
  }

  // Handle arrays differently as they maintain their order and are treated as objects with indices.
  if (Array.isArray(obj)) {
    const compactArr = [];
    for (const item of obj) {
      // Recursively call compactObject on each element.
      const compactedItem = compactObject(item);
      // Check for truthiness.
      if (Boolean(compactedItem)) {
        compactArr.push(compactedItem);
      }
    }
    return compactArr;
  }

  // Handle objects.
  const compactObj = {};
  for (const key in obj) {
    if (Object.prototype.hasOwnProperty.call(obj, key)) {
      const value = obj[key];
      // Recursively call compactObject on the value.
      const compactedValue = compactObject(value);
      // Check for truthiness of the compacted value.
      if (Boolean(compactedValue)) {
        compactObj[key] = compactedValue;
      }
    }
  }
  return compactObj;
};
