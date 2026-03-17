// Last updated: 17/3/2026, 11:16:35 am
1class Solution {
2    public static int maxCoins(int[] nums) {
3		int[] arr = new int[nums.length+2];
4		int n  = arr.length;
5		int[][] dp = new int[arr.length][arr.length];
6		
7		arr[0] = arr[n-1] = 1;
8		for(int i = 1; i<=nums.length; i++) {
9			arr[i] = nums[i-1];
10			
11		}
12		
13		for (int i = n - 1; i >= 0; i--) {
14	        for (int j = i + 2; j < n; j++) {
15	            int ans = 0;
16	            for (int k = i + 1; k < j; k++) {
17	                int fs = dp[i][k];
18	                int ls = dp[k][j];
19	                int self = arr[i] * arr[k] * arr[j];
20	                ans = Math.max(ans, fs + ls + self);
21	            }
22	            dp[i][j] = ans;
23	        }
24	    }
25		
26		for(int [] x:dp) {
27			System.out.println(Arrays.toString(x));
28		}
29		
30		return dp[0][arr.length-1];
31
32	}
33}