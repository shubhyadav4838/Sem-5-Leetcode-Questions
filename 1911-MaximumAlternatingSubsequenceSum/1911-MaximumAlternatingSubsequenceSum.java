// Last updated: 30/3/2026, 2:45:52 pm
1class Solution {
2    public static long maxAlternatingSum(int[] arr) {
3		int n = arr.length;
4		long[][] dp = new long[n][2];
5		
6		for(long[] x:dp) {
7			Arrays.fill(x,-1);
8		}
9		// mark -> 0(add), 1(sub);
10		long ans = solve(arr,dp,0,0);
11		return ans;
12		
13
14	}
15
16	private static long solve(int[] arr, long[][] dp, int mark, int idx) {
17		// TODO Auto-generated method stub
18		if(idx>=arr.length) {
19			return 0;
20		}
21		
22		if(dp[idx][mark]!=-1) {
23			return dp[idx][mark];
24		}
25		
26		// skip the current one
27		long skip = solve(arr,dp, mark,idx+1);
28		long a = 0;
29		long b = 0;
30		
31		if(mark==0) {
32			a =  solve(arr,dp,1,idx+1)+arr[idx];
33		}else {
34			b = solve(arr,dp,0,idx+1)-arr[idx];
35		}
36		
37		return dp[idx][mark] = Math.max(skip, Math.max(a, b));
38	}
39
40}