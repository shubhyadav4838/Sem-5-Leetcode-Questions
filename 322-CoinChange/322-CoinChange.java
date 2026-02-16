// Last updated: 16/2/2026, 8:01:42 pm
1class Solution {
2    public static int coinChange(int[] coins, int amount) {
3		int[] dp = new int[amount+1];
4		Arrays.fill(dp, amount+1);
5		
6		dp[0] = 0;
7		for(int i = 1;i<dp.length;i++) {
8			for(int coin : coins) {
9				if(coin<=i) {
10					dp[i] = Math.min(dp[i],dp[i-coin]+1);
11				}
12			}
13		}
14		return dp[amount] >amount ? -1 : dp[amount];
15	}
16}