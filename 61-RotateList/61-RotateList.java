// Last updated: 4/8/2025, 12:01:07 am
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        
        k = k % length;
        if (k == 0) return head;

        ListNode first = reverse(head);

        temp = first;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }

        ListNode second = temp.next;
        temp.next = null;

        ListNode firstPart = reverse(first);
        ListNode secondPart = reverse(second);

        temp = firstPart;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = secondPart;

        return firstPart;
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
