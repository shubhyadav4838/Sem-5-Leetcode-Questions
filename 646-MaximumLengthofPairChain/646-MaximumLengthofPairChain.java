// Last updated: 14/10/2025, 1:28:28 am
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int[][] dp = new int[pairs.length][pairs.length];
        for(int[] x: dp){
            Arrays.fill(x,-10000);
        }

        return maxChain(pairs,0,0,0,dp);
        
    }

    public static int maxChain(int[][] arr, int i, int pre,int len,int[][] dp){
        if(i==arr.length){
            return len;
        }

        if(dp[i][pre]!=-10000){
            return dp[i][pre];
        }

        int a=0,b=0;
        if(i==0 || arr[i][0]>arr[pre][1]){
            a = maxChain(arr,i+1,i,len+1,dp);
        }
        b = maxChain(arr,i+1,pre,len,dp);

        return dp[i][pre] = Math.max(a,b);

    }
}