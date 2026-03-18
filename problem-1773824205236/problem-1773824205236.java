// Last updated: 18/3/2026, 2:26:45 pm
1class Solution {
2    public static int minScoreTriangulation(int[] arr) {
3		int[][] dp = new int[arr.length][arr.length];
4		for(int[] x:dp) {
5			Arrays.fill(x,-1);
6		}
7		return solve(arr, 0, arr.length - 1,dp);
8	}
9
10	private static int solve(int[] arr, int i, int j, int[][] dp) {
11		// TODO Auto-generated method stub
12		if (i + 1 == j) {
13			return 0;
14		}
15		
16		if(dp[i][j]!=-1) {
17			return dp[i][j];
18		}
19		int ans = Integer.MAX_VALUE;
20		for (int k = i + 1; k < j; k++) {
21			int fs = solve(arr, i, k, dp);
22			int ls = solve(arr, k, j, dp);
23			int self = arr[i] * arr[k] * arr[j];
24			ans = Math.min(ans, self + fs + ls);
25		}
26		return dp[i][j] = ans;
27	}
28}