/** 
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.

**/

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode prev = null, slow = head, fast = head;
        
        // find middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // disconnect left half
        if (prev != null) prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head == slow ? null : head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
