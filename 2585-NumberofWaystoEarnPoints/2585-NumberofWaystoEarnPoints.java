// Last updated: 16/3/2026, 7:39:11 pm
1class Solution {
2    static int MOD = (int)(1e9 + 7);
3	public static int waysToReachTarget(int target, int[][] types) {
4		int[][] dp = new int[target+1][types.length+1];
5		for(int i = 0;i<dp[0].length;i++) {
6			dp[0][i] = 1;
7		}
8		for(int remain = 1; remain<=target; remain++) {
9			for(int idx = types.length-1; idx>=0; idx--) {
10				int ans = 0;
11				
12				int count = types[idx][0];
13				int marks = types[idx][1];
14				for(int i = 0; i<= count; i++) {
15					int curr = i*marks;
16					if(curr>remain)break;
17					int req = dp[remain-curr][idx+1];
18					ans = (ans+req)%MOD;
19				}
20				dp[remain][idx] = ans;
21			}
22		}
23		
24		return dp[target][0];
25		
26	}
27}