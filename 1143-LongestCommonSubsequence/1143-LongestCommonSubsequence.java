// Last updated: 27/7/2026, 11:32:24 am
1class Solution {
2    public static int longestCommonSubsequence(String s1, String s2) {
3		int[][] dp = new int[1001][1001];
4		for(int[] x:dp) {
5			Arrays.fill(x, -1);
6		}
7		int ans = solve(s1,s2,0,0,dp);
8		return ans;
9	}
10
11	private static int solve(String s1, String s2, int i, int j, int[][] dp) {
12		// TODO Auto-generated method stub
13		if(i>=s1.length() || j>=s2.length())
14		return 0;
15		
16		if(dp[i][j]!=-1) {
17			return dp[i][j];
18		}
19		int ans = 0;
20		if(s1.charAt(i)==s2.charAt(j)) {
21			ans = solve(s1,s2,i+1,j+1,dp) + 1;
22			
23		}
24		int b = solve(s1,s2,i+1,j,dp);
25		int c = solve(s1,s2,i,j+1,dp);
26		
27		return dp[i][j] = Math.max(ans, Math.max(b, c));
28		
29	}
30}