// Last updated: 18/3/2026, 3:36:36 pm
1class Solution {
2   public static int getMoneyAmount(int n) { 
3		
4		int[][] dp = new int[n+2][n+2];
5		for(int[] x:dp) {
6			Arrays.fill(x,-1);
7		}
8		
9		return solve(1,n,dp);
10	}
11
12	private static int solve( int i, int j, int[][] dp) {
13		// TODO Auto-generated method stub
14		if (i>= j) {
15			return 0;
16		}
17		
18		if(dp[i][j]!=-1) {
19			return dp[i][j];
20		}
21		int ans = 999999;
22		for (int k = i ; k <= j; k++) {
23			int fs = solve(i,k-1,dp);
24			int ls = solve(k+1,j,dp);
25			int self = k;
26			ans = Math.min(ans, self+Math.max(fs, ls));
27		}
28		return dp[i][j] = ans;
29	}
30}