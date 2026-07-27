// Last updated: 27/7/2026, 11:44:51 am
class Solution {
    public int maxScore(int[] nums) {
        int size = (1<<14);
        int[] dp = new int[size];
        Arrays.fill(dp,-1);
        return solve(nums,1,0,dp);
    }

    public static int solve(int[] arr, int op, int mask, int[] dp){
        int m = arr.length;
        int n = m/2;
        if(op>n) return 0;

        if(dp[mask]!=-1){
            return dp[mask];
        }

        for(int i = 0;i<m;i++){
            if((mask & (1<<i))!=0)continue;
            for(int j = i+1; j<m; j++){
                if((mask & (1<<j))!=0)continue;
                int newMask = (1<<i) | (1<<j) | mask;
                int score =op * gcd(arr[i],arr[j]) + solve(arr,op+1,newMask, dp);
                dp[mask] = Math.max(dp[mask],score);

            }
        }

        return dp[mask];
    }

    public static int gcd(int a, int b){
        while(a>0){
            int rem = b%a;
            b = a;
            a = rem;
        }
        return b;
    }
}