// Last updated: 17/3/2026, 12:23:52 pm
1class Solution {
2    public static int minCost(int target, int[] cuts) {
3        int[] arr = new int[cuts.length + 2];
4        int n = arr.length;
5        for(int i = 1; i <= cuts.length; i++) {
6            arr[i] = cuts[i - 1];
7        }
8        
9        arr[0] = 0;
10        arr[n - 1] = target;
11        
12        Arrays.sort(arr);
13        
14        int[][] dp = new int[n][n];
15        for(int i = n-1 ; i>=0; i--) {
16        	for(int j = i+2; j<n;j++) {
17        		
18        		int ans = Integer.MAX_VALUE;
19        		for(int k = i+1;k<j;k++) {
20        			int fs = dp[i][k];
21        			int ls = dp[k][j];
22        			int self = arr[j]-arr[i];
23        			ans = Math.min(ans, fs+ls+self);
24        		}
25        		dp[i][j] = ans;
26        		
27        	}
28        }
29        
30        return dp[0][n-1];
31
32    }
33}