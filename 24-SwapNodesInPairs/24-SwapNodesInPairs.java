// Last updated: 4/8/2025, 12:01:57 am
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode nxt = current.next;
            current.next = nxt.next;
            nxt.next = current;
            prev.next = nxt;
            prev = current;
            current = current.next;
        }

        return dummy.next;
    }
}