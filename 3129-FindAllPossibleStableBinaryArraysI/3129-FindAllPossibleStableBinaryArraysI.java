// Last updated: 10/3/2026, 12:19:25 pm
1class Solution {
2    static int MOD = (int)(1e9 + 7);
3    public int numberOfStableArrays(int zero, int one, int limit) {
4        Integer[][][] dp = new Integer[zero+1][one+1][2];
5        long useone = solve(zero,one,1,limit,dp);
6        long notuse = solve(zero,one,0,limit,dp);
7        long ans = (useone+notuse)%MOD;
8        return (int)ans;
9    }
10
11    public static long solve(int zero, int one, int usedone, int limit,Integer[][][] dp) {
12        if(zero == 0 && one == 0)return 1;
13        long result = 0;
14        if(dp[zero][one][usedone]!=null){
15            return dp[zero][one][usedone];
16        }
17        if(usedone==1){
18            int range = Math.min(limit,zero);
19            for(int len = 1; len<=range; len++){
20                long val = solve(zero-len,one,0,limit,dp);
21                result = (result+val)%MOD;
22            }
23        }else{
24             int range = Math.min(limit,one);
25            for(int len = 1; len<=range; len++){
26                long val = solve(zero,one-len,1,limit,dp);
27                result = (result+val)%MOD;
28            }
29        }
30        return dp[zero][one][usedone] = (int)result;
31    }
32
33}