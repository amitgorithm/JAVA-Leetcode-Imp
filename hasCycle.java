/* Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list. */

class Solution {
    public boolean hasCycle(ListNode hd) {
        if (hd == null || hd.next == null) return false;

        ListNode sl = hd;
        ListNode ft = hd.next;

        while (sl != ft) {
            if (ft == null || ft.next == null) return false;
            sl = sl.next;
            ft = ft.next.next;
        }

        return true;
    }
}
