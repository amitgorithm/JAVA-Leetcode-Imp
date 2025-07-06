/* Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
The number of nodes in the list is in the range [1, 5000].
1 <= Node.val <= 1000Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers. */

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            int gcdVal = gcd(current.val, current.next.val);
            ListNode newNode = new ListNode(gcdVal);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
