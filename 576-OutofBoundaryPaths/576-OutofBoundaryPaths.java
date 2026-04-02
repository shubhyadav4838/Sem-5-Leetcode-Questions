// Last updated: 2/4/2026, 2:33:22 pm
1class Solution {
2    static int MOD = 1000_000_007;
3	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
4        Long[][][] dp = new Long[m][n][maxMove+1];
5        
6		return (int)solve(m,n,maxMove, startRow, startColumn,dp)%MOD;
7    }
8	
9	public static long solve(int r, int c, int move, int curr, int curc, Long[][][] dp) {
10		if(curr<0 || curc<0 || curr>=r || curc>=c) {
11			return 1;
12		}
13		if( move<=0) {
14			return 0;
15		}
16		
17        if(dp[curr][curc][move]!=null){
18            return dp[curr][curc][move];
19        }
20		long a = solve(r,c,move-1,curr+1,curc,dp)%MOD;
21		long b = solve(r,c,move-1,curr-1,curc,dp)%MOD;
22		long e = solve(r,c,move-1,curr,curc+1,dp)%MOD;
23		long d = solve(r,c,move-1,curr,curc-1,dp)%MOD;
24		return dp[curr][curc][move] = (long)(a+b+e+d)%MOD;
25	}
26}