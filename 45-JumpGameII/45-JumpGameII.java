// Last updated: 18/9/2025, 11:26:25 pm
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return minJump(nums,0,dp);
    }
    public static int minJump(int[] arr, int idx, int[] dp){
        if(idx>=arr.length-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int ans =1000000;
        for(int i = 1;i<=arr[idx];i++){
            ans = Math.min(minJump(arr,idx+i, dp),ans);
        }
        return dp[idx] = ans+1;
    }
}