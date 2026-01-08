// Last updated: 8/1/2026, 12:08:27 pm
1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        if (k == 0 || prices.length == 0) return 0;
4
5        int[] buy = new int[k + 1];
6        int[] sell = new int[k + 1];
7
8        Arrays.fill(buy, Integer.MIN_VALUE);
9
10        for (int price : prices) {
11            for (int i = 1; i <= k; i++) {
12                buy[i] = Math.max(buy[i], sell[i - 1] - price);
13
14                sell[i] = Math.max(sell[i], buy[i] + price);
15            }
16        }
17        
18        return sell[k];
19    }
20}