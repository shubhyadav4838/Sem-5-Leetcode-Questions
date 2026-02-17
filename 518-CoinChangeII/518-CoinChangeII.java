// Last updated: 17/2/2026, 6:58:19 pm
1class Solution {
2    public static int change(int amount, int[] arr) {
3		int[][] dp = new int[arr.length+1][amount+1];
4		
5		for(int i = 0;i<dp.length;i++) {
6			dp[i][0] = 1;
7		}
8		
9		for(int i = 1;i<dp.length;i++) {
10			for(int am = 1;am<dp[0].length;am++ ) {
11				int exc = dp[i-1][am];
12				int inc = 0;
13				if(am>=arr[i-1]) {
14					inc = dp[i][am-arr[i-1]];
15				}
16				dp[i][am] = exc+inc;
17			}
18		}
19		return dp[arr.length][amount];
20
21	}
22
23}