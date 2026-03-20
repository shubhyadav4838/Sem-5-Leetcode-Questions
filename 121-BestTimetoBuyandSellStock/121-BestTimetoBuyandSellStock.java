// Last updated: 20/3/2026, 10:47:12 pm
1class Solution {
2    public int maxProfit(int[] prices) {
3        return buySell(prices);
4    }
5    public static int buySell(int[]arr) {
6		int buy=arr[0];
7		int ans=0;
8		for (int i = 1; i < arr.length; i++) {
9			if(arr[i]>buy) {
10				ans=Math.max(ans,arr[i]-buy);
11			}else {
12				buy=arr[i];
13			}
14		}
15		return ans;
16	}
17}