// Last updated: 15/7/2026, 9:46:12 am
1class Solution {
2    public static int subsequencePairCount(int[] arr) {
3		Integer[][][] dp = new Integer[arr.length][201][201];
4		return solve(0,0,0,arr,dp);
5
6	}
7	static int MOD = (int)1e9 + 7;
8	
9	public static int solve(int seqa,int seqb, int idx,int[] arr,Integer[][][] dp) {
10		if(idx>=arr.length) {
11			return (seqa!=0 && seqa==seqb ? 1:0);
12		}
13		
14		if(dp[idx][seqa][seqb]!=null) {
15			return dp[idx][seqa][seqb];
16		}
17		
18		long ans = 0;
19		ans += solve(seqa, seqb, idx+1, arr, dp)%MOD;
20		
21		int vala = gcd(seqa,arr[idx]);
22		int valb = gcd(seqb,arr[idx]);
23		
24		ans += solve(vala, seqb, idx+1, arr, dp)%MOD;
25		ans += solve(seqa, valb, idx+1, arr, dp)%MOD;
26		
27		return dp[idx][seqa][seqb] = (int)(ans%MOD);
28		
29	}
30	
31	private static int gcd(int a, int b) {
32        while (b != 0) {
33            int t = a % b;
34            a = b;
35            b = t;
36        }
37        return a;
38    }
39}