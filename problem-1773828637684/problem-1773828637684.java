// Last updated: 18/3/2026, 3:40:37 pm
1class Solution {
2   public static int getMoneyAmount(int n) { 
3		
4		int[][] dp = new int[n+2][n+2];
5		for(int i = n; i>0; i--) {
6			for(int j = i+1; j<=n;j++) {
7				int ans = Integer.MAX_VALUE;
8				for(int k = i; k<=j; k++) {
9					int fs = dp[i][k-1];
10					int ls = dp[k+1][j];
11					int self = k;
12					ans = Math.min(ans, self+Math.max(fs, ls));
13				}
14				dp[i][j] = ans;
15			}
16		}
17		
18		return dp[1][n];
19	}
20}