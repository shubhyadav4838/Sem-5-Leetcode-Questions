// Last updated: 3/8/2025, 11:58:09 pm
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
    public ListNode addTwoNumbers(ListNode l11, ListNode l22) {
        ListNode l1 = null;
    ListNode current = l11;

    while (current != null) {
        ListNode next = current.next; // store next node
        current.next = l1;          // reverse the link
        l1 = current;               // move prev forward
        current = next;               // move current forward
    }

 ListNode l2 = null;
    ListNode currentt = l22;

    while (currentt != null) {
        ListNode next = currentt.next; // store next node
        currentt.next = l2;          // reverse the link
        l2 = currentt;               // move prev forward
        currentt = next;               // move current forward
    }


        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int d1 = (l1 != null) ? l1.val : 0;
            int d2 = (l2 != null) ? l2.val : 0;

            int sum = d1 + d2 + carry;
            int val = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(val);
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

         ListNode lt2 = null;
    ListNode currenttt = dummy.next;

    while (currenttt != null) {
        ListNode next = currenttt.next; // store next node
        currenttt.next = lt2;          // reverse the link
        lt2 = currenttt;               // move prev forward
        currenttt = next;               // move current forward
    }

    return lt2;
    }
}