// Last updated: 27/7/2026, 11:45:12 am
class Solution {
    public static int minCost(int target, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        int n = arr.length;
        for(int i = 1; i <= cuts.length; i++) {
            arr[i] = cuts[i - 1];
        }
        
        arr[0] = 0;
        arr[n - 1] = target;
        
        Arrays.sort(arr);
        
        int[][] dp = new int[n][n];
        for(int i = n-1 ; i>=0; i--) {
        	for(int j = i+2; j<n;j++) {
        		
        		int ans = Integer.MAX_VALUE;
        		for(int k = i+1;k<j;k++) {
        			int fs = dp[i][k];
        			int ls = dp[k][j];
        			int self = arr[j]-arr[i];
        			ans = Math.min(ans, fs+ls+self);
        		}
        		dp[i][j] = ans;
        		
        	}
        }
        
        return dp[0][n-1];

    }
}