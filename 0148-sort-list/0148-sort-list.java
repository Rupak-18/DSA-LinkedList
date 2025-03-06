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
    private static ListNode findMiddle(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode mergeLL(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(left != null && right != null) {
            if(left.val <= right.val) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
            else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        if(left != null) 
            temp.next = left;
        else 
            temp.next = right;
        return dummyNode.next;
    }


    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(midNext);
        return mergeLL(leftNode, rightNode);
    }
}