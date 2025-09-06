// Last updated: 6/9/2025, 11:10:24 pm
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr[arr.length-1][arr[0].length-1]==1)return 0;
        int[][] dp = new int[arr.length][arr[0].length];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        return fun(0,0,arr,0,dp);
        
    }
    public int fun(int r,int c,int[][] arr,int ans,int[][] dp){
        if(r<0 || r>=arr.length || c<0 || c>=arr[0].length || arr[r][c]==1){
            return 0;
        }
        if(r==arr.length-1 && c==arr[0].length-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int a = fun(r+1,c,arr,ans,dp);
        int b = fun(r,c+1,arr,ans,dp);
        return dp[r][c] = a+b;
    }
}