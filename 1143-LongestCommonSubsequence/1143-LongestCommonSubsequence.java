// Last updated: 29/3/2026, 1:06:15 pm
1class Solution {
2    public static int longestCommonSubsequence(String text1, String text2) {
3		int[] dp = new int[text2.length() + 1];
4        int n = text1.length();
5		
6		for (int i = 1; i <= text1.length(); i++) {
7			for (int j = text2.length(); j >0; j--) {
8				if (text1.charAt(i-1 ) == text2.charAt(j - 1)) {
9					dp[j] =  dp[j-1]+1;
10				} 
11			}
12            for (int j = 1; j <= text2.length(); j++) {
13				if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
14					dp[j] = Math.max(dp[j], dp[j - 1]);
15				} 
16			}
17            
18		}
19		return dp[text2.length()];
20	}
21}