// Last updated: 18/3/2026, 2:30:33 pm
1class Solution {
2    public static int minScoreTriangulation(int[] arr) {
3		int[][] dp = new int[arr.length][arr.length];
4
5		for(int i=arr.length-1; i>=0;i--) {
6			for(int j = i+2;j<dp[0].length;j++) {
7				int ans = Integer.MAX_VALUE;
8				for(int k = i+1; k<j; k++) {
9					int fs = dp[i][k];
10					int ls = dp[k][j];
11					int self = arr[i] * arr[j] * arr[k];
12					ans = Math.min(ans, self + fs + ls);
13				}
14				dp[i][j] = ans;
15			}
16		}
17		return dp[0][arr.length-1];
18	}
19}