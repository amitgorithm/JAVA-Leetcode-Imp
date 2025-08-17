/* Write a generator function that returns a generator object which yields the fibonacci sequence.

The fibonacci sequence is defined by the relation Xn = Xn-1 + Xn-2.

The first few numbers of the series are 0, 1, 1, 2, 3, 5, 8, 13. */

function* fibonacciGenerator() {
  let a = 0;
  let b = 1;
  // The first number in the sequence is always 0.
  yield a;
  // The second number in the sequence is always 1.
  yield b;

  // We use a while loop to generate the rest of the sequence indefinitely.
  while (true) {
    // Calculate the next number in the sequence.
    const next = a + b;
    // Update the values for the next iteration.
    a = b;
    b = next;
    // Yield the newly calculated number.
    yield next;
  }
}
