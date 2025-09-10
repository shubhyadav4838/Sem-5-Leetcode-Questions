// Last updated: 10/9/2025, 12:21:13 pm
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
		
		int ld = minFalling(matrix,cr+1,cc-1,dp);
		int rd = minFalling(matrix,cr+1,cc,dp);
		int d = minFalling(matrix,cr+1,cc+1,dp);
		return dp[cr][cc] = Math.min(ld,Math.min(rd, d)) + matrix[cr][cc];
		
		
	}
}