// Last updated: 15/7/2026, 9:58:17 am
1class Solution {
2    public static int subsequencePairCount(int[] arr) {
3		Integer[][][] dp = new Integer[arr.length][201][201];
4		return solve(0,0,0,arr,dp);
5
6	}
7	static int MOD = (int)1e9 + 7;
8	
9	public static int solve(int seqa, int seqb, int idx, int[] arr, Integer[][][] dp) {
10		if (idx >= arr.length) {
11			return (seqa != 0 && seqa == seqb ? 1 : 0);
12		}
13
14		if (dp[idx][seqa][seqb] != null) {
15			return dp[idx][seqa][seqb];
16		}
17
18		long ans = 0;
19		ans += solve(seqa, seqb, idx + 1, arr, dp) % MOD;
20
21		ans += solve(gcd(seqa, arr[idx]), seqb, idx + 1, arr, dp) % MOD;
22		ans += solve(seqa, gcd(seqb, arr[idx]), idx + 1, arr, dp) % MOD;
23
24		return dp[idx][seqa][seqb] = (int) (ans % MOD);
25
26	}
27	
28	private static int gcd(int a, int b) {
29        while (b != 0) {
30            int t = a % b;
31            a = b;
32            b = t;
33        }
34        return a;
35    }
36}