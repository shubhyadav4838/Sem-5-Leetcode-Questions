// Last updated: 16/2/2026, 7:21:28 pm
1class Solution {
2   public static boolean canPartition(int[] arr) {
3		int sum = 0;
4        for(int x:arr){
5            sum+=x;
6        }
7        if(sum%2!=0)return false;
8        int target = sum/2;
9        Boolean[][] dp = new Boolean[arr.length+1][target+1];
10        return solve(arr,0,target,dp);
11	}
12	
13	public static boolean solve(int[] arr, int idx, int target, Boolean[][] dp) {
14		if(target==0) {
15			return true;
16		}
17		if(target<0) {
18			return false;
19		}
20		if(idx==arr.length)return false;
21		
22		if(dp[idx][target]!=null) {
23			return dp[idx][target];
24		}
25		boolean inc = false;
26		if(target-arr[idx]>=0) {
27			inc = solve(arr,idx+1,target-arr[idx],dp);
28			
29		}
30		boolean exc = solve(arr,idx+1,target,dp);
31		
32		return dp[idx][target] = inc || exc;
33		
34		
35	}
36}