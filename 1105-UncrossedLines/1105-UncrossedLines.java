// Last updated: 27/7/2026, 11:46:24 am
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return maxLines(nums1,nums2);
    }
    public static int maxLines(int[] arra, int[] arrb) {
		 int[][] dp = new int[arra.length+1][arrb.length+1];
		 for(int row = 1;row<dp.length;row++) {
			 for(int col = 1;col<dp[0].length;col++) {
				 if(arra[row-1]==arrb[col-1]) {
					 dp[row][col] = dp[row-1][col-1]+1;
				 }else {
					 dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
				 }
			 }
		 }
		 return dp[dp.length-1][dp[0].length-1];
	}
}