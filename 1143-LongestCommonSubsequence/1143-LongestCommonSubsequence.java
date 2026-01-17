// Last updated: 17/1/2026, 3:18:12 pm
1class Solution {
2   public static int longestPalindromeSubseq(String s) {
3		int[][] dp = new int[s.length() + 1][s.length() + 1];
4		int n = s.length();
5		for (int i = 1; i <= n; i++) {
6			for (int j = 1; j <= n; j++) {
7				
8				if (s.charAt(i - 1) == s.charAt(n-j)) {
9					dp[i][j] = 1 + dp[i - 1][j - 1];
10				} else {
11					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
12				}
13			}
14		}
15		return dp[n][n];
16	}
17
18	
19}