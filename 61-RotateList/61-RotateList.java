// Last updated: 5/5/2026, 9:01:08 pm
1public class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null || k == 0) return head;
4
5        
6        int length = 0;
7        ListNode temp = head;
8        while (temp != null) {
9            length++;
10            temp = temp.next;
11        }
12
13        
14        k = k % length;
15        if (k == 0) return head;
16
17        ListNode first = reverse(head);
18
19        temp = first;
20        for (int i = 1; i < k && temp != null; i++) {
21            temp = temp.next;
22        }
23
24        ListNode second = temp.next;
25        temp.next = null;
26
27        ListNode firstPart = reverse(first);
28        ListNode secondPart = reverse(second);
29
30        temp = firstPart;
31        while (temp.next != null) {
32            temp = temp.next;
33        }
34        temp.next = secondPart;
35
36        return firstPart;
37    }
38
39    public static ListNode reverse(ListNode head) {
40        ListNode curr = head, prev = null;
41        while (curr != null) {
42            ListNode next = curr.next;
43            curr.next = prev;
44            prev = curr;
45            curr = next;
46        }
47        return prev;
48    }
49}
50