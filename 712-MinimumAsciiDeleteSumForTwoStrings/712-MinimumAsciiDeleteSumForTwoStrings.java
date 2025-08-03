// Last updated: 3/8/2025, 11:57:00 pm
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char [] S1=s1.toCharArray();
        char [] S2=s2.toCharArray();
        int [][] dp=new int[S1.length+1][S2.length+1];

        for(int i=1;i<=S1.length;i++){
            dp[i][0]=dp[i-1][0]+S1[i-1];
        }
        for(int j=1;j<=S2.length;j++){
            dp[0][j]=dp[0][j-1]+S2[j-1];
        }
        for(int k=1;k<=S1.length;k++){
            for(int l=1;l<=S2.length;l++){
                if(S1[k-1]==S2[l-1]){
                    dp[k][l]=dp[k-1][l-1];
                }
                else{
                    dp[k][l]=Math.min(dp[k-1][l]+S1[k-1],dp[k][l-1]+S2[l-1]);
                }
            }
        }
        return dp[S1.length][S2.length];
        
    }
}