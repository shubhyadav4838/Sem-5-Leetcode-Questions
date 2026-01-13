// Last updated: 13/1/2026, 7:38:07 pm
1class Solution {
2    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
3        int n = piles.size();
4        int[][] dp = new int[n + 1][k + 1];
5
6        for (int i = 1; i <= n; i++) {
7            
8            for (int w = 0; w <= k; w++) {
9                
10                dp[i][w] = dp[i - 1][w];
11                int currentPileSum = 0;
12                int limit = Math.min(w, piles.get(i - 1).size());
13                
14                for (int taken = 1; taken <= limit; taken++) {
15                    currentPileSum += piles.get(i - 1).get(taken - 1);
16                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - taken] + currentPileSum);
17                }
18            }
19        }
20        
21        return dp[n][k];
22    }
23}