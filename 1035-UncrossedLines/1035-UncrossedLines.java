// Last updated: 7/1/2026, 9:40:32 pm
1class Solution {
2    public int maxUncrossedLines(int[] nums1, int[] nums2) {
3        return maxLines(nums1,nums2);
4    }
5    public static int maxLines(int[] arra, int[] arrb) {
6		 int[][] dp = new int[arra.length+1][arrb.length+1];
7		 for(int row = 1;row<dp.length;row++) {
8			 for(int col = 1;col<dp[0].length;col++) {
9				 if(arra[row-1]==arrb[col-1]) {
10					 dp[row][col] = dp[row-1][col-1]+1;
11				 }else {
12					 dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
13				 }
14			 }
15		 }
16		 return dp[dp.length-1][dp[0].length-1];
17	}
18}