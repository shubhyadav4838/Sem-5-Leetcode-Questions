// Last updated: 30/3/2026, 3:48:01 pm
1class Solution {
2   public static int maximumSum(int[] arr) {
3		int n = arr.length;
4		
5		int ans = Integer.MIN_VALUE;
6		int[][]dp = new int[n+1][2];
7		for(int[] x:dp) {
8			Arrays.fill(x, -999999);
9		}
10		
11	
12		for(int i = n-1;i>=0;i--) {
13			for(int delete = 0; delete<2; delete++) {
14				
15				int old = arr[i] + dp[i+1][delete];
16				int ifdel = -999999;
17				if(arr[i]<0 && delete==0) {
18					ifdel = dp[i+1][1];
19				}
20				dp[i][delete] = Math.max(arr[i], Math.max(old, ifdel));
21				ans = Math.max(ans, dp[i][delete]);
22			}
23		}
24		return ans;
25		
26
27	}
28}