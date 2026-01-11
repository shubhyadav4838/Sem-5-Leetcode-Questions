// Last updated: 12/1/2026, 12:23:40 am
1class Solution {
2    static Boolean[][] dp; 
3	public static boolean canPartition(int[] arr) {
4		int sum = 0;
5		for(int x:arr) {
6			sum+=x;
7		}
8		if(sum%2!=0) {
9			return false;
10		}
11		int target = sum/2;
12		dp = new Boolean[arr.length][target+1];
13		return solve(0,0,target,arr,dp);
14		
15	}
16	
17	private static boolean solve(int sum, int idx, int target,int[] arr, Boolean[][] dp ) {
18		// TODO Auto-generated method stub
19		if(sum==target) {
20			return true;
21		}
22		if(sum>target || idx==arr.length) {
23			return false;
24		}
25		
26		if(dp[idx][sum]!=null) {
27			return dp[idx][sum];
28		}
29		boolean inc = solve(sum+arr[idx],idx+1,target,arr,dp);
30		boolean exc = solve(sum,idx+1,target,arr,dp);
31		return dp[idx][sum] = inc|| exc;
32	}
33}