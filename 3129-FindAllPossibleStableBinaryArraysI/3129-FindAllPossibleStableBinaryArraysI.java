// Last updated: 10/3/2026, 3:34:09 pm
class Solution {

    static final int MOD = 1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp = new long[zero + 1][one + 1][2];
        for(int z = 0; z <= zero; z++)
            dp[z][0][0] = z <= limit? 1 : 0;
        for(int o = 0; o <= one; o++)
            dp[0][o][1] = o <= limit? 1 : 0;
        for(int z = 1; z <= zero; z++)
            for(int o = 1; o <= one; o++)
                for(int k = 1; k <= limit; k++){
                    if(z - k >= 0)
                        dp[z][o][0] = (dp[z][o][0] + dp[z - k][o][1]) % MOD;
                    if(o - k >= 0)
                        dp[z][o][1] = (dp[z][o][1] + dp[z][o - k][0]) % MOD;
                }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}