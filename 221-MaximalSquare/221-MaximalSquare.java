// Last updated: 22/1/2026, 10:20:41 pm
1class Solution {
2    public static int maximalSquare(char[][] arr) {
3		int ans = 0;
4		int[][] dp = new int[arr.length][arr[0].length];
5		for(int i = 0;i<arr.length;i++) {
6			if(arr[i][0]=='1') {
7				dp[i][0] = 1;
8				ans = 1;
9			}
10		}
11		for(int i = 0;i<arr[0].length;i++) {
12			if(arr[0][i]=='1') {
13				dp[0][i] = 1;
14				ans = 1;
15			}
16		}
17		
18		
19		for(int i = 1;i<arr.length;i++) {
20			for(int j = 1;j<arr[0].length;j++) {
21				if(arr[i][j]=='0')continue;
22				
23				dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
24				ans = Math.max(ans, dp[i][j]);
25				
26			}
27		}
28		return ans*ans;
29
30	}
31}