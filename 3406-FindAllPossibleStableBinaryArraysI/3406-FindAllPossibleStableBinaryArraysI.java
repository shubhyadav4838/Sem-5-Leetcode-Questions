// Last updated: 27/7/2026, 11:43:27 am
class Solution {
    static int MOD = (int)(1e9 + 7);
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[one+1][zero+1][2];
        // long useone = solve(zero,one,1,limit,dp);
        // long notuse = solve(zero,one,0,limit,dp);
        // long ans = (useone+notuse)%MOD;
        // return (int)ans;
        return bottomUp(zero,one,limit,dp);
    }

    public static int bottomUp(int zero, int one, int limit, int[][][]dp){
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for(int oneleft = 0; oneleft<=one; oneleft++){
            for(int zeroleft = 0; zeroleft<=zero; zeroleft++){
                if(oneleft==0 && zeroleft==0)continue;
                int result = 0;
                for(int len = 1; len<=Math.min(limit,zeroleft); len++){
                    int val = dp[oneleft][zeroleft-len][0];
                    result = (result+val)%MOD;

                }
                dp[oneleft][zeroleft][1] = result;

                result = 0;
                for(int len = 1; len<=Math.min(limit,oneleft); len++){
                    int val = dp[oneleft-len][zeroleft][1];
                    result = (result+val)%MOD;

                }
                dp[oneleft][zeroleft][0] = result;

            }
        }
        int a = dp[one][zero][0];
        int b = dp[one][zero][1];
        return (a+b)%MOD;
    }

    public static long solve(int zero, int one, int usedone, int limit,Integer[][][] dp) {
        if(zero == 0 && one == 0)return 1;
        long result = 0;
        if(dp[zero][one][usedone]!=null){
            return dp[zero][one][usedone];
        }
        if(usedone==1){
            int range = Math.min(limit,zero);
            for(int len = 1; len<=range; len++){
                long val = solve(zero-len,one,0,limit,dp);
                result = (result+val)%MOD;
            }
        }else{
             int range = Math.min(limit,one);
            for(int len = 1; len<=range; len++){
                long val = solve(zero,one-len,1,limit,dp);
                result = (result+val)%MOD;
            }
        }
        return dp[zero][one][usedone] = (int)result;
    }

}