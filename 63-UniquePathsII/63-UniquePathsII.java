// Last updated: 6/9/2025, 11:33:18 pm
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        // if(arr[arr.length-1][arr[0].length-1]==1)return 0;
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]==1){
                break;
            }
            dp[i][0] = 1;
        }
        for(int i=0;i<arr[0].length;i++){
            if(arr[0][i]==1){
                break;
            }
            dp[0][i] = 1;
        }
        for(int r=1;r<arr.length;r++){
            for(int c=1;c<arr[0].length;c++){
                if(arr[r][c]==1)continue;
                dp[r][c] = dp[r-1][c]+dp[r][c-1];
            }
        }
       
        return dp[arr.length-1][arr[0].length-1];
        
    }
   
}