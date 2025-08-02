/* Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {

        if (head == null) return null;

        ArrayList<Integer> ar = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            ar.add(current.val);
            current = current.next;
        }

        Collections.sort(ar);

        current = head;
        for (int i = 0; i < ar.size(); i++) {
            current.val = ar.get(i);
            current = current.next;
        }

        return head; 
    }
}
