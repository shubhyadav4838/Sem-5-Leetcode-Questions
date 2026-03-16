// Last updated: 16/3/2026, 7:18:21 pm
1class Solution {
2    static int MOD = (int) (1e9 + 7);
3
4    public static int waysToReachTarget(int target, int[][] types) {
5        Integer[][] dp = new Integer[target + 1][types.length];
6
7        return solve(target, types, target, 0, dp);
8
9    }
10
11    public static int solve(int target, int[][] types, int remain, int idx, Integer[][] dp) {
12        if (remain == 0) {
13            return 1;
14        }
15        if (idx >= types.length || remain < 0) {
16            return 0;
17        }
18
19        if (dp[remain][idx] != null) {
20            return dp[remain][idx];
21        }
22
23        int ans = 0;
24        int count = types[idx][0];
25        int marks = types[idx][1];
26        for (int i = 0; i <= count; i++) {
27            int curr = (i) * marks;
28            if (curr > remain)
29                break;
30            int req = solve(target, types, remain - curr, idx + 1, dp);
31            ans = (ans + req) % MOD;
32
33        }
34        return dp[remain][idx] = ans % MOD;
35
36    }
37}