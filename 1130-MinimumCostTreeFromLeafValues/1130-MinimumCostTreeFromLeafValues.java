// Last updated: 18/3/2026, 10:40:58 pm
1class Solution {
2    static class Pair{
3		int max = 0;
4		int sum=0;
5	}
6
7	public static int mctFromLeafValues(int[] arr) {
8        try{
9
10        
11        int n = arr.length;
12        Pair[][] dp = new Pair[n][n];
13		return solve(0,arr.length-1,arr,dp).sum;
14        }catch (Throwable t) { // <--- CHANGED FROM Exception e
15			System.out.println("CRITICAL DEBUG -> " + t.toString());
16			if (t.getStackTrace().length > 0) {
17				System.out.println("FAILED AT LINE: " + t.getStackTrace()[0].getLineNumber());
18			}
19            return 0;
20		}
21	}
22	
23	public static Pair solve(int i, int j, int[] arr,Pair[][] dp) {
24		if(i>j) {
25			return new Pair();
26		}
27		if(i==j) {
28			Pair curr = new Pair();
29			curr.max = arr[i];
30			return curr;
31			
32		}
33        if(dp[i][j]!=null){
34            return dp[i][j];
35        }
36		
37		Pair self = new Pair();
38		int ans = Integer.MAX_VALUE;
39		int max = 0;
40		
41		for(int k = i; k<j;k++) {
42			Pair left = solve(i,k,arr,dp);
43			Pair right = solve(k+1,j,arr,dp);
44			
45			int prod = left.max * right.max;
46			int sum = left.sum+right.sum+prod;
47			if(sum<ans) {
48				ans = sum;
49				max = Math.max(left.max, right.max);	
50			}
51		}
52		self.sum = ans;
53		self.max = max;
54		return dp[i][j] = self;
55	}
56}