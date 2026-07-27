// Last updated: 27/7/2026, 11:44:03 am
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        Integer[][][] dp = new Integer [grid.length][grid[0].length][k];
        return solve(grid,k,dp,0,0,0);
    }
    
    static int mod = 1_000_000_007;
    public static int solve(int[][] arr, int k, Integer[][][] dp,int r, int c,int sum){
        if(r==arr.length-1 && c==arr[0].length-1){
            return (sum+arr[r][c])%k==0?1:0;
        }else if(r==arr.length || c==arr[0].length){
            return 0;
        }
        sum = (sum+arr[r][c])%k;
        if(dp[r][c][sum]!=null){
            return dp[r][c][sum]%mod;
        }

        int right = solve(arr,k,dp,r,c+1,sum);
        int down = solve(arr,k,dp,r+1,c,sum);
        return dp[r][c][sum] = (down+right)%mod;

    }
}