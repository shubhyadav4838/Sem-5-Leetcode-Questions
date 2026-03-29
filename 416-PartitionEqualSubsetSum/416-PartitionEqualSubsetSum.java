// Last updated: 29/3/2026, 12:32:27 pm
1class Solution {
2    public static boolean canPartition(int[] arr) {
3		int sum = 0;
4		for(int x:arr) {
5			sum += x;
6		}
7		if(sum%2!=0) {
8			return false;
9		}
10		
11		sum = sum/2;
12		boolean[][] dp = new boolean[arr.length+1][sum+1];
13		for(int i = 0;i<dp.length;i++) {
14			dp[i][0] = true;
15		}
16		
17		for(int idx = dp.length-2;  idx>=0; idx--) {
18			for(int j = 0; j<dp[0].length; j++) {
19				
20				boolean exc = dp[idx+1][j];
21				boolean inc = false;
22				if(arr[idx]<=j) {
23					inc = dp[idx+1][j-arr[idx]];
24				}
25				
26				dp[idx][j] = exc|inc;
27			}
28		}
29		
30		return dp[0][sum];
31	}
32	
33}