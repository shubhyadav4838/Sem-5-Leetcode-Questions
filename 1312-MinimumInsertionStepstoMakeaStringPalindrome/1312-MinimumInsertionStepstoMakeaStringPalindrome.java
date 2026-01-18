// Last updated: 19/1/2026, 12:38:07 am
1class Solution {
2    public int minInsertions(String s) {
3    
4        int n = s.length();
5        if(n==1){
6            return 0;
7        }
8        int[][] dp = new int[n][n];
9        for(int i = n-1;i>=0;i--){
10            for(int j = i+1;j<n;j++){
11               
12                if(s.charAt(i)==s.charAt(j)){
13                    dp[i][j] = dp[i+1][j-1];
14                }
15                else{
16                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
17                }
18            }
19        }
20        return dp[0][n-1];
21    }
22}