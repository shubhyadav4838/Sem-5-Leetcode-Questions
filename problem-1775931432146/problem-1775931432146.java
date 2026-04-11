// Last updated: 11/4/2026, 11:47:12 pm
1class Solution {
2    public int maxScore(int[] nums) {
3        int size = (1<<14);
4        int[] dp = new int[size];
5        Arrays.fill(dp,-1);
6        return solve(nums,1,0,dp);
7    }
8
9    public static int solve(int[] arr, int op, int mask, int[] dp){
10        int m = arr.length;
11        int n = m/2;
12        if(op>n) return 0;
13
14        if(dp[mask]!=-1){
15            return dp[mask];
16        }
17
18        for(int i = 0;i<m;i++){
19            if((mask & (1<<i))!=0)continue;
20            for(int j = i+1; j<m; j++){
21                if((mask & (1<<j))!=0)continue;
22                int newMask = (1<<i) | (1<<j) | mask;
23                int score =op * gcd(arr[i],arr[j]) + solve(arr,op+1,newMask, dp);
24                dp[mask] = Math.max(dp[mask],score);
25
26            }
27        }
28
29        return dp[mask];
30    }
31
32    public static int gcd(int a, int b){
33        while(a>0){
34            int rem = b%a;
35            b = a;
36            a = rem;
37        }
38        return b;
39    }
40}