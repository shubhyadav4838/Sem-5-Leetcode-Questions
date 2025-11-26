// Last updated: 27/11/2025, 1:07:39 am
1class Solution {
2    public int numberOfPaths(int[][] grid, int k) {
3        Integer[][][] dp = new Integer [grid.length][grid[0].length][k];
4        return solve(grid,k,dp,0,0,0);
5    }
6    
7    static int mod = 1_000_000_007;
8    public static int solve(int[][] arr, int k, Integer[][][] dp,int r, int c,int sum){
9        if(r==arr.length-1 && c==arr[0].length-1){
10            return (sum+arr[r][c])%k==0?1:0;
11        }else if(r==arr.length || c==arr[0].length){
12            return 0;
13        }
14        sum = (sum+arr[r][c])%k;
15        if(dp[r][c][sum]!=null){
16            return dp[r][c][sum]%mod;
17        }
18
19        int right = solve(arr,k,dp,r,c+1,sum);
20        int down = solve(arr,k,dp,r+1,c,sum);
21        return dp[r][c][sum] = (down+right)%mod;
22
23    }
24}