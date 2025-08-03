// Last updated: 4/8/2025, 12:02:06 am
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
            size++;
        }
        size-=n;
        if(size < 0) return head.next;
        temp = head;
        while(size-->0){
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next = temp.next.next;
            }
        return head;
        
    }
}