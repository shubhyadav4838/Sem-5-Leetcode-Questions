// Last updated: 18/3/2026, 7:17:44 pm
1class Solution {
2    static class Pair{
3		int max = 0;
4		int sum=0;
5	}
6
7	public static int mctFromLeafValues(int[] arr) {
8        int n = arr.length;
9        Pair[][] dp = new Pair[n][n];
10		return solve(0,arr.length-1,arr,dp).sum;
11	}
12	
13	public static Pair solve(int i, int j, int[] arr,Pair[][] dp) {
14		if(i>j) {
15			return new Pair();
16		}
17		if(i==j) {
18			Pair curr = new Pair();
19			curr.max = arr[i];
20			return curr;
21			
22		}
23        if(dp[i][j]!=null){
24            return dp[i][j];
25        }
26		
27		Pair self = new Pair();
28		int ans = Integer.MAX_VALUE;
29		int max = 0;
30		
31		for(int k = i; k<j;k++) {
32			Pair left = solve(i,k,arr,dp);
33			Pair right = solve(k+1,j,arr,dp);
34			
35			int prod = left.max * right.max;
36			int sum = left.sum+right.sum+prod;
37			if(sum<ans) {
38				ans = sum;
39				max = Math.max(left.max, right.max);	
40			}
41		}
42		self.sum = ans;
43		self.max = max;
44		return dp[i][j] = self;
45	}
46}