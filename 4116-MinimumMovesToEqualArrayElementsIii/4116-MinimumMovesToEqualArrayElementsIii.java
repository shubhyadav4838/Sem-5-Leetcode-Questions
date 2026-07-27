// Last updated: 27/7/2026, 11:42:13 am
class Solution {
   public static int minMoves(int[] nums) {
        int maxm = Integer.MIN_VALUE;
        int total = 0;
        for(int x : nums) {
        	maxm = Math.max(x,maxm);
        }
        for(int x : nums) {
        	total+=maxm-x;
        }
        return total;
    }
}