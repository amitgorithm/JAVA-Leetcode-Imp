/** Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed. 
**/

class Solution {
    public ListNode swapPairs(ListNode origin) {
        ListNode ghost = new ListNode(0);
        ghost.next = origin;
        ListNode scout = ghost;

        while (scout.next != null && scout.next.next != null) {
            ListNode alpha = scout.next;
            ListNode beta = scout.next.next;

            alpha.next = beta.next;
            beta.next = alpha;
            scout.next = beta;

            scout = alpha;
        }
        return ghost.next;
    }
}
