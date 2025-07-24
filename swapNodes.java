/* You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100 */

class Solution {
    public ListNode swapNodes(ListNode hd, int k) {
        ListNode f = hd, s = hd;
        int len = 0;

        // First pass to get length and kth from start
        for (int i = 1; i <= k; i++) {
            f = f.next;
        }

        ListNode a = hd;
        for (int i = 1; i < k; i++) {
            a = a.next;
        }

        // Second pointer to find kth from end
        ListNode b = hd;
        ListNode p = f;
        while (p != null) {
            b = b.next;
            p = p.next;
        }

        // Swap values
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;

        return hd;
    }
}
