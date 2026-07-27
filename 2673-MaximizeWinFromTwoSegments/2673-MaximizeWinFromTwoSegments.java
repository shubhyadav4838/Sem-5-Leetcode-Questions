// Last updated: 27/7/2026, 11:43:51 am
class Solution {
    public static int maximizeWin(int[] arr, int k) {
		int[] dp = new int[arr.length+1];
		int ans = 0;
		int left = 0;
		
		for(int i = 0;i<arr.length;i++) {
			while(arr[i]-arr[left]>k)left++;
			
			int range = i-left+1;
			
			dp[i+1] = Math.max(dp[i], range);
			ans = Math.max(ans, range+dp[left]);
		}
		return ans;
		
	}
}