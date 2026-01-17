// Last updated: 17/1/2026, 3:13:16 pm
1class Solution {
2   public static int longestPalindromeSubseq(String s) {
3		String reversed = new StringBuilder(s).reverse().toString();
4		return longestCommonSubsequence(s,reversed);
5	}
6
7	public static int longestCommonSubsequence(String text1, String text2) {
8		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
9		for (int i = 1; i <= text1.length(); i++) {
10			for (int j = 1; j <= text2.length(); j++) {
11				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
12					dp[i][j] = 1 + dp[i - 1][j - 1];
13				} else {
14					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
15				}
16			}
17		}
18		return dp[text1.length()][text2.length()];
19	}
20}