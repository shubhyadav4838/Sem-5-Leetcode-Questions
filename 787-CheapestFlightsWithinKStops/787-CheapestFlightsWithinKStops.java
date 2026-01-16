// Last updated: 16/1/2026, 3:26:40 pm
1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        
4        int[] dp = new int[n];
5        Arrays.fill(dp, Integer.MAX_VALUE);
6        dp[src] = 0;
7
8        for (int i = 0; i <= k; i++) {
9            int[] temp = dp.clone();
10            
11            for (int[] flight : flights) {
12                int u = flight[0]; 
13                int v = flight[1]; 
14                int price = flight[2]; 
15
16                if (dp[u] != Integer.MAX_VALUE && dp[u] + price < temp[v]) {
17                    temp[v] = dp[u] + price;
18                }
19            }
20            dp = temp;
21        }
22        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
23    }
24}