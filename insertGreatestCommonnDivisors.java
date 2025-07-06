/* Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
The number of nodes in the list is in the range [1, 5000].
1 <= Node.val <= 1000Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers. */



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
    public int gcd(int val1,int val2){
        int result=Math.min(val1,val2);
        while(result>0){
            if(val1%result==0 && val2%result==0){
                break;
            }
            result--;
        }
        return result;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode ptr1=head;
        ListNode ptr2=head.next;
        while(ptr2!=null){
            int insertingValue=gcd(ptr1.val,ptr2.val);
            ListNode newNode=new ListNode(insertingValue);
            ptr1.next=newNode;
            newNode.next=ptr2;
            ptr1=ptr2;
            ptr2=ptr1.next;
        }
        return head;
    }
}
