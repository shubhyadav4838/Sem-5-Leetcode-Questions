// Last updated: 30/3/2026, 3:00:50 pm
1class Solution {
2   public static long maxAlternatingSum(int[] arr) {
3		int n = arr.length;
4		long[][] dp = new long[n+1][2];
5		
6		for(int i = n-1; i>=0; i--) {
7			for(int j = 0; j<2; j++) {
8				long skip = dp[i+1][j];
9				long a = 0;
10				long b = 0;
11				if(j==0) {
12					a = dp[i+1][1]+arr[i];
13				}else {
14					b = dp[i+1][0]-arr[i];
15				}
16				
17				dp[i][j] = Math.max(skip, Math.max(a, b));
18			}
19		}
20		return dp[0][0];
21	}
22
23}