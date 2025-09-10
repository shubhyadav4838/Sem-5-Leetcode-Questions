// Last updated: 10/9/2025, 12:34:50 pm
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for(int[] arr:dp) {
			Arrays.fill(arr, Integer.MIN_VALUE);
		}
		for(int col=0;col<matrix[0].length;col++) {
			ans = Math.min(ans, minFalling(matrix,0,col,dp));
		}
        return ans;
        
    }
    public static int minFalling(int[][] matrix,int cr,int cc,int[][] dp) {
		if(cc<0 || cc>=matrix[0].length) {
			return Integer.MAX_VALUE;
		}
		if(cr==matrix.length -1) {
			return matrix[cr][cc];
		}
		if(dp[cr][cc] != Integer.MIN_VALUE) {
			return dp[cr][cc];
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<matrix.length;i++) {
			if(i==cc) {
				continue;
			}
			ans = Math.min(ans, minFalling(matrix,cr+1,i,dp));
			
		}
		return dp[cr][cc] = ans + matrix[cr][cc];	
	}
}