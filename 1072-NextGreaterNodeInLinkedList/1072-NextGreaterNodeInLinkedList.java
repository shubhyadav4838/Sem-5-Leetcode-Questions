// Last updated: 3/8/2025, 11:55:36 pm
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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ll=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
       
        while(head!=null){
            ll.add(head.val);
            head=head.next;
        } 
        int[] ans=new int[ll.size()];
        for(int i=ll.size()-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=ll.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=0;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(ll.get(i));
        }
        return ans;
        
    }
}