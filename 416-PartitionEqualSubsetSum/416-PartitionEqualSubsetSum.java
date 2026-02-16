// Last updated: 16/2/2026, 7:11:40 pm
1class Solution {
2    public boolean canPartition(int[] arr) {
3        int sum = 0;
4        for(int x:arr){
5            sum+=x;
6        }
7        if(sum%2!=0)return false;
8        int target = sum/2;
9        boolean[] dp = new boolean[target+1];
10        dp[0] = true;
11        for(int i = 0;i<arr.length;i++){
12            for(int j = target; j>=arr[i] ;j--){
13                if(dp[j-arr[i]]==true){
14                    dp[j] = true;
15                }
16            }
17        }
18        return dp[target];
19        
20    }
21}