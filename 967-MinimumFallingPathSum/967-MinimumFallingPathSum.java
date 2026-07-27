// Last updated: 27/7/2026, 11:46:55 am
class Solution {
    public static int minFallingPathSum(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		for(int i = 1;i<n;i++) {
			for(int j = 0;j<m;j++) {
				int right = 999999, left = 999999;
				if(j>0)left = arr[i-1][j-1];
				if(j<m-1)right = arr[i-1][j+1];
				arr[i][j] += Math.min(left, Math.min(arr[i-1][j], right));
				
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0;i<m;i++) {
			ans = Math.min(ans, arr[n-1][i]);
		}
       
		return ans;

	}

}