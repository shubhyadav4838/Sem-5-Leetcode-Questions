// Last updated: 12/1/2026, 1:30:26 am
1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int[] dp = new int[amount + 1];
4        
5        Arrays.fill(dp, amount + 1);
6        
7        dp[0] = 0;
8        
9        for (int i = 1; i <= amount; i++) {
10            for (int coin : coins) {
11                if (coin <= i) {
12                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
13                }
14            }
15        }
16        
17        return dp[amount] > amount ? -1 : dp[amount];
18    }
19}