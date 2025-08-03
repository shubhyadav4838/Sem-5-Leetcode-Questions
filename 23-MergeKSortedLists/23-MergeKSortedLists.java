// Last updated: 4/8/2025, 12:01:59 am
/**
* Definition for singly-linked list.
*
*class ListNode {
*    int val;
*    ListNode next;
*    ListNode() {}
*    ListNode(int val) { this.val = val; }
*    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode head : lists) {
            while (head != null) {
                pq.add(head.val);
                head = head.next;
            }
        }

        if (pq.isEmpty()) return null;

        ListNode head = new ListNode(pq.poll());
        ListNode temp = head;

        while (!pq.isEmpty()) {
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }

        return head;
    }
}
