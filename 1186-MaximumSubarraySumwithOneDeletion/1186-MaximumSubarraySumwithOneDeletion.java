// Last updated: 30/3/2026, 3:42:05 pm
1class Solution {
2    public static int maximumSum(int[] arr) {
3		int n = arr.length;
4		
5		int ans = Integer.MIN_VALUE;
6		int[][]dp = new int[n][2];
7		for(int[] x : dp) {
8			Arrays.fill(x, -1);
9		}
10		
11		for(int i = 0;i<arr.length;i++) {
12			ans = Math.max(ans, solve(arr,i,0,dp));
13		}
14		return ans;
15		
16
17	}
18
19	public static int solve(int[] arr, int i, int delete, int[][] dp) {
20		if(i>=arr.length) {
21			return -999999;
22		}
23		
24		if(dp[i][delete]!=-1) {
25			return dp[i][delete];
26		}
27		// part of old array
28		int old = arr[i] + solve(arr,i+1,delete,dp);
29		// skip is negative
30		int ifdel = -999999;
31		if(arr[i]<0 && delete==0) {
32			ifdel = solve(arr,i+1,1,dp);
33		}
34		
35		return dp[i][delete] =  Math.max(arr[i],Math.max(old, ifdel));
36		
37		
38	}
39}