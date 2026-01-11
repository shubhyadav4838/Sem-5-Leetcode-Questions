// Last updated: 12/1/2026, 1:09:53 am
1class Solution {
2   public static int coinChange(int[] arr, int amount) {
3		int[] dp = new int[amount+1];
4		Arrays.fill(dp, -1);
5        int ans = solve(amount,arr,dp); 
6		return (ans==999999999) ? -1:ans;
7	}
8	
9	public static int solve(int target, int[] arr,int[] dp) {
10		if(target==0) {
11			return 0;
12		}
13		if(target<0) {
14			return 999999999;
15		}
16		
17		if(dp[target]!=-1) {
18			return dp[target];
19		}
20		
21		int ans = 999999999;
22		for(int i = 0;i<arr.length;i++) {
23			int res = Math.min(ans,solve(target-arr[i],arr,dp));
24			if(res!=99999999) {
25				ans = Math.min(ans, res+1);
26			}
27			
28		}
29		return dp[target] = ans;
30		
31	}
32}