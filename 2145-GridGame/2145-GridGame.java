// Last updated: 3/8/2025, 11:54:16 pm
class Solution {
    public long gridGame(int[][] grid) {
        return MaxPoints(grid);
    }
    public static long MaxPoints(int[][]grid){
        long top_sum = 0;
        for(int i=grid[0].length-1;i>=0;i--) {
        	top_sum+=grid[0][i];
        }
        long b_sum = 0;
        long min_sum=Long.MAX_VALUE;
        for(int i = 0;i<grid[0].length;i++) {
        	top_sum-=grid[0][i];
        	min_sum = Math.min(min_sum, Math.max(top_sum, b_sum));
        	b_sum+=grid[1][i];
        }
        return min_sum;
	}
}