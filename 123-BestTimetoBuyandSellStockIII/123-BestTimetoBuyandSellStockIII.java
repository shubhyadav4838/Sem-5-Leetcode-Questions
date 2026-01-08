// Last updated: 8/1/2026, 11:19:28 am
1class Solution {
2    public int maxProfit(int[] prices) {
3        int buy1 = Integer.MIN_VALUE;
4        int buy2 = Integer.MIN_VALUE;
5        
6        int sell1 = 0;
7        int sell2 = 0;
8
9        for (int price : prices) {
10           
11            buy1 = Math.max(buy1, -price);
12            
13            sell1 = Math.max(sell1, buy1 + price);
14            buy2 = Math.max(buy2, sell1 - price);
15            sell2 = Math.max(sell2, buy2 + price);
16        }
17
18        return sell2;
19    }
20}