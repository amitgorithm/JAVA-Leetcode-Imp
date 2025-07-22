/* Given the head of a singly linked list, reverse the list, and return the reversed list.
Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

write cryptic varibale names but keep it sensible */


class Solution {
    public ListNode reverseList(ListNode h) {
        ListNode p = null;
        while (h != null) {
            ListNode n = h.next;
            h.next = p;
            p = h;
            h = n;
        }
        return p;
    }
}
