// Last updated: 13/2/2026, 4:58:13 pm
1class Solution {
2    public int uniquePaths(int m, int n) {
3        
4        int[][] dp =new int[m][n];
5        dp[0][0] = 1;
6        for(int i = 0;i<m;i++){
7            for(int j = 0;j<n;j++){
8                if(j+1<n){
9                    dp[i][j+1] += dp[i][j];
10                }
11                if(i+1<m){
12                    dp[i+1][j] += dp[i][j];
13                }
14            }
15        }
16        return dp[m-1][n-1];
17    }
18}