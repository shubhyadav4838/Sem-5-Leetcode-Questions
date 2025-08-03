// Last updated: 4/8/2025, 12:00:36 am
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
    public ListNode partition(ListNode head, int k) {
        ListNode temp = head;
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode lh = large;
        ListNode sh = small;
        ListNode t = temp;
        while(t!=null ){
            if(t.val<k){
               small.next = t;
                small=small.next;
            }else{
                large.next = t;
                large=large.next;
            }
            t=t.next;
        }
        small.next=lh.next;
        large.next = null;
        return sh.next;   
    }
}