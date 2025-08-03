// Last updated: 3/8/2025, 11:56:38 pm
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp=new double[query_row+1];
        dp[0]=poured;
        for(int row=1;row<=query_row;row++){
            for(int col=row-1;col>=0;col--){
                if(dp[col]>1){
                    double val=(dp[col]-1)/2;
                    dp[col]=val;
                    dp[col+1]+=val;
                }
                else{
                    dp[col]=0;
                }
            }
        }
        return Math.min(1,dp[query_glass]);
        
    }
}