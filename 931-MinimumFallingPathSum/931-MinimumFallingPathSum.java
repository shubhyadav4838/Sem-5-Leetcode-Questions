// Last updated: 24/1/2026, 5:18:44 pm
1class Solution {
2    public static int minFallingPathSum(int[][] arr) {
3		int n = arr.length;
4		int m = arr[0].length;
5		for(int i = 1;i<n;i++) {
6			for(int j = 0;j<m;j++) {
7				int right = 999999, left = 999999;
8				if(j>0)left = arr[i-1][j-1];
9				if(j<m-1)right = arr[i-1][j+1];
10				arr[i][j] += Math.min(left, Math.min(arr[i-1][j], right));
11				
12			}
13		}
14		int ans = Integer.MAX_VALUE;
15		for(int i = 0;i<m;i++) {
16			ans = Math.min(ans, arr[n-1][i]);
17		}
18       
19		return ans;
20
21	}
22
23}