// Last updated: 8/11/2025, 8:10:26 pm
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