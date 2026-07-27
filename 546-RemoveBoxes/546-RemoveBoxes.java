// Last updated: 27/7/2026, 11:12:33 am
1class Solution {
2    public static int removeBoxes(int[] arr) {
3		int n = arr.length-1;
4		Integer[][][] dp = new Integer[101][101][101];
5		
6		int ans = solve(0,n,0,arr,dp);
7        return ans;
8    }
9	private static int solve(int l, int r, int k, int[] arr, Integer[][][]dp) {
10		// TODO Auto-generated method stub
11		if(l>r) {
12			return 0;
13		}
14		if(dp[l][r][k]!=null) {
15			return dp[l][r][k];
16		}
17		
18		int ans = (k+1)*(k+1) + solve(l,r-1,0,arr,dp);
19		
20		for(int i=l; i<r;i++) {
21			if(arr[i]==arr[r]) {
22				int val = solve(i+1,r-1,0,arr,dp) + solve(l,i,k+1,arr,dp);
23				ans = Math.max(ans, val);
24			}
25		}
26		
27		return dp[l][r][k]= ans;
28	}
29}