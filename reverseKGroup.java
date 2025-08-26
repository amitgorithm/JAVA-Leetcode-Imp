/** Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000 **/

/**
 * Definition for singly-linked list.
 * This class is typically provided by the LeetCode platform, but we include
 * it here for a complete, runnable solution.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /**
     * Reverses the nodes of a linked list k at a time.
     *
     * @param head The head of the linked list.
     * @param k The size of the group to reverse.
     * @return The head of the modified list.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Create a dummy node to simplify handling the new head of the list.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode tail = curr;
            int count = 0;

            // Check if there are at least k nodes remaining.
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }

            // If there are not enough nodes, break the loop and leave the rest of the list as is.
            if (count < k) {
                break;
            }

            // Reverse the sublist of k nodes.
            ListNode reversedHead = reverseList(curr, k);
            
            // Connect the previous part of the list to the new head of the reversed group.
            prev.next = reversedHead;
            
            // Update the `prev` and `curr` pointers for the next group.
            // The `prev` pointer should now point to the original head of the group,
            // which is now the tail of the reversed group.
            prev = curr;
            // The `curr` pointer should now point to the node that was originally the (k+1)-th node.
            curr = tail;
        }

        return dummy.next;
    }

    /**
     * Helper function to reverse a sublist of a given size.
     *
     * @param head The head of the sublist to reverse.
     * @param k The number of nodes to reverse.
     * @return The new head of the reversed sublist.
     */
    private ListNode reverseList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        // Perform a standard iterative reversal for k nodes.
        while (k > 0) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
            k--;
        }
        
        // After the loop, `head` (the original head) is now the tail of the reversed list.
        // Its `next` pointer should point to the rest of the list, which is at `curr`.
        head.next = curr;
        
        // The new head of the reversed list is `prev`.
        return prev;
    }
}
