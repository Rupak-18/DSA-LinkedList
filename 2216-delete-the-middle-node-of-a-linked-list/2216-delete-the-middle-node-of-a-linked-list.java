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
    public ListNode deleteMiddle(ListNode head) {      
        if(head == null || head.next == null)
            return null;

        ListNode tort = head;
        ListNode hare = head;
        while(hare.next.next != null && hare.next.next.next != null) {
            tort = tort.next;
            hare = hare.next.next;
        }
        tort.next = tort.next.next;
        return head;
    }
}