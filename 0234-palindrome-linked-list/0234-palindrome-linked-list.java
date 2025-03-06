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
    public static ListNode reverseLinkedList(ListNode newHead) {
        ListNode temp = newHead;
        ListNode prev = null;
        while(temp != null) {
            ListNode after = temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverseLinkedList(slow.next);
        ListNode first = head;
        while(second != null) {
            if(first.val != second.val) {
                reverseLinkedList(slow.next);
                return false;
            }
            second = second.next;
            first = first.next;
        }
        reverseLinkedList(slow.next);
        return true;
    }
}