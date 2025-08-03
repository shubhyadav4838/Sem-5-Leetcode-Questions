// Last updated: 4/8/2025, 12:00:09 am
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
     public boolean hasCycle(ListNode head) {
		    	 ListNode fast = head;
			        ListNode slow = head;
			        while(fast!=null && fast.next!=null){
			            slow = slow.next;
			            fast = fast.next.next;
			            if(slow==fast) {
			            	return true;
			            }
			        }
			        return false;
		        
		    }
}