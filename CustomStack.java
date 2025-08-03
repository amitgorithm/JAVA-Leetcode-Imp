/* Design a stack that supports increment operations on its elements.

Implement the CustomStack class:

CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
int pop() Pops and returns the top of the stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
*/

class CustomStack {
    private int[] stackArray;
    private int stackTop;
    private int maxCapacity;

    public CustomStack(int maxSize) {
        this.stackArray = new int[maxSize];
        this.stackTop = -1;
        this.maxCapacity = maxSize;
    }

    public void push(int x) {
        if (stackTop < maxCapacity - 1) {
            stackArray[++stackTop] = x;
        }
    }

    public int pop() {
        return stackTop >= 0 ? stackArray[stackTop--] : -1;
    }

    // Renamed from 'inc' to 'increment' to match the test case
    public void increment(int k, int val) {
        int elementsToUpdate = Math.min(k, stackTop + 1);
        for (int i = 0; i < elementsToUpdate; i++) {
            stackArray[i] += val;
        }
    }
}
