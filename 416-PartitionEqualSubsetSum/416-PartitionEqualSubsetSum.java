// Last updated: 29/3/2026, 12:21:42 pm
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
12		Boolean[][] dp = new Boolean[arr.length][sum+1];
13		return solve(0,arr,sum, dp);
14	}
15	
16	public static boolean solve(int idx,int[] arr, int sum, Boolean[][] dp) {
17		if(sum==0)return true;
18		if(sum<0 || idx>=arr.length) return false;
19		
20		if(dp[idx][sum]!=null) {
21			return dp[idx][sum];
22		}
23		
24		boolean exc = solve(idx+1, arr,sum, dp);
25		boolean inc = false;
26		if(arr[idx]<=sum) {
27			inc = solve(idx+1,arr,sum-arr[idx], dp);
28		}
29		
30		return dp[idx][sum] = exc | inc;
31	}
32}