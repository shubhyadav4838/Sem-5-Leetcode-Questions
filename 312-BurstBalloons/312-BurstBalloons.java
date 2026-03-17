// Last updated: 17/3/2026, 10:55:26 am
1class Solution {
2    public static int maxCoins(int[] nums) {
3		int n  = nums.length+2;
4		int[] arr = new int[n];
5		int[][] dp = new int[arr.length][arr.length];
6		for(int [] x:dp) {
7			Arrays.fill(x,-1);
8		}
9		arr[0] = arr[n-1] = 1;
10		for(int i = 1; i<=nums.length; i++) {
11			arr[i] = nums[i-1];
12			
13		}
14		return solve(arr,0,arr.length-1,dp);
15
16	}
17	
18	public static int solve(int[] arr, int i, int j,int[][] dp) {
19		if(i==j) {
20			return arr[i];
21		}
22		
23		if(dp[i][j]!=-1) {
24			return dp[i][j];
25		}
26		
27		int ans = 0;
28		for(int k = i+1; k<j;k++) {
29			int fs = solve(arr,i,k,dp);
30			int ls = solve(arr,k,j,dp);
31			int self = arr[i] * arr[k] * arr[j];
32			ans = Math.max(ans, fs+ls+self);
33		}
34		return dp[i][j] = ans;
35	}
36}