// Last updated: 27/1/2026, 1:46:55 pm
1class Solution {
2    public static int maxCoins(int[] nums) {
3		int n = nums.length;
4		int[] arr = new int[n+2];
5		arr[0] = arr[n+1] = 1;
6		for(int i = 0;i<n;i++) {
7			arr[i+1] = nums[i];
8		}
9		int[][] dp = new int[n+2][n+2];
10		for(int[] x:dp) {
11			Arrays.fill(x, -1);
12		}
13		
14		return solve(arr,0,n+1,dp);
15		
16	
17	}
18	
19	
20	public static int solve(int[] arr,int i, int j, int[][]dp) {
21		if(i==j) {	
22			return arr[i];
23		}
24		
25		if(dp[i][j]!=-1) {
26			return dp[i][j];
27		}
28		
29		int ans = 0;
30		for(int k = i+1;k<j;k++) {
31			int fs = solve(arr,i,k,dp);
32			int ls = solve(arr,k,j,dp);
33			int self = arr[i]*arr[k]*arr[j];
34			ans = Math.max(ans, fs+ls+self);
35			
36		}
37		return dp[i][j] = ans;
38	}
39}