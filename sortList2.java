/* Given the head of a linked list, return the list after sorting it in ascending order. */
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left,right); // Placeholder return - replace with your solution
    }

    public ListNode mergeList(ListNode list1, ListNode list2){
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while (list1!=null && list2!=null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        while (list1 != null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while (list2 != null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return ans.next;
    }

    public ListNode findMid(ListNode head){
        ListNode prevMid = null;
        while (head != null && head.next != null){
            prevMid = (prevMid == null) ? head : prevMid.next;
            head = head.next.next;
        }
        ListNode mid = prevMid.next;
        prevMid.next = null;
        return mid;
    }
}
