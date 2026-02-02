// Last updated: 2/2/2026, 7:51:16 pm
1class Solution {
2    public static int maximizeWin(int[] arr, int k) {
3		int[] dp = new int[arr.length+1];
4		int ans = 0;
5		int left = 0;
6		
7		for(int i = 0;i<arr.length;i++) {
8			while(arr[i]-arr[left]>k)left++;
9			
10			int range = i-left+1;
11			
12			dp[i+1] = Math.max(dp[i], range);
13			ans = Math.max(ans, range+dp[left]);
14		}
15		return ans;
16		
17	}
18}