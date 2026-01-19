// Last updated: 19/1/2026, 8:10:26 pm
1class Solution {
2    public static int numDistinct(String s, String t) {
3		int n = s.length();
4		int m = t.length();
5		int[][] dp = new int[n + 1][m + 1];
6
7		for (int i = 0; i <= n; i++) {
8			dp[i][0] = 1;
9		}
10		dp[0][0] = 1;
11		for (int i = 1; i <= n; i++) {
12			for (int j = 1; j <= m; j++) {
13				dp[i][j] = dp[i - 1][j];
14				if (s.charAt(i - 1) == t.charAt(j - 1)) {
15					dp[i][j] += dp[i - 1][j - 1];
16				}
17			}
18		}
19
20		
21		return dp[n][m];
22	}
23}