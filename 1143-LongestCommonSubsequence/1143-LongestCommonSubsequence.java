// Last updated: 6/1/2026, 3:56:44 pm
1class Solution {
2    public static int longestCommonSubsequence(String s1, String s2) {
3		int[][] dp = new int[s2.length()+1][s1.length()+1];
4		for(int row = 1;row<dp.length;row++) {
5			for(int col = 1; col<dp[0].length;col++) {
6				if(s1.charAt(col-1)==s2.charAt(row-1)) {
7					dp[row][col] = dp[row-1][col-1]+1;
8				}else {
9					dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
10				}
11			}
12		}
13		return dp[dp.length-1][dp[0].length-1];
14	}
15}