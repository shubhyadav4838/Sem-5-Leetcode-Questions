// Last updated: 23/2/2026, 3:40:50 pm
1class Solution {
2    public static int maxProfit(int[] prices) {
3		int n = prices.length;
4		int cool = Integer.MIN_VALUE;
5		int hold = -prices[0];
6		int free = 0;
7
8		for (int i = 1; i < n; i++) {
9			int precool = cool;
10			int prehold = hold;
11			int prefree = free; 
12			
13			free = Math.max(precool, prefree);
14			hold = Math.max(prehold, prefree-prices[i]);
15			cool = prehold + prices[i];
16			
17		}
18		return Math.max(free, cool);
19
20	}
21}