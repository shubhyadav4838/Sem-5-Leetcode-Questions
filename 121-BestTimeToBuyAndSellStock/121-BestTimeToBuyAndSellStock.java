// Last updated: 4/8/2025, 12:00:26 am
class Solution {
    public int maxProfit(int[] prices) {
        return buySell(prices);
    }
    public static int buySell(int[]arr) {
		int buy=arr[0];
		int ans=0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>buy) {
				ans=Math.max(ans,arr[i]-buy);
			}else {
				buy=arr[i];
			}
		}
		return ans;
	}
}