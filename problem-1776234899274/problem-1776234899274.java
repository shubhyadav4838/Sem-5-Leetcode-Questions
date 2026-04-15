// Last updated: 15/4/2026, 12:04:59 pm
1class Solution {
2    public static int countArrangement(int n) {
3		int[][] dp = new int[n+1][1<<(n+1)];
4		for(int[] x:dp) {
5			Arrays.fill(x, -1);		}
6		return solve(1,n,0,dp); 
7	}
8
9	public static int solve(int val, int n, int mask,int[][] dp) {
10		if (val > n)
11			return 1;
12		
13		if(dp[val][mask]!=-1) {
14			return dp[val][mask];
15		}
16
17		int score = 0;
18		for (int i = 1; i <= n; i++) {
19			if ((mask & (1 << i)) != 0)continue;
20			if(i%val==0 || val%i==0) {
21				int newMask = mask | (1<<i);
22				score += solve(val+1,n,newMask,dp);
23				
24			}
25		}
26		
27		return dp[val][mask] = score;
28	}
29
30}