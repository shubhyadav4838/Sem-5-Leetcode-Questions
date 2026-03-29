// Last updated: 29/3/2026, 12:43:05 pm
1class Solution {
2    public static boolean canPartition(int[] arr) {
3        int sum = 0;
4        for (int x : arr) {
5            sum += x;
6        }
7        if (sum % 2 != 0) {
8            return false;
9        }
10
11        sum = sum / 2;
12
13        boolean[] dp = new boolean[sum + 1];
14        dp[0] = true;
15
16        for (int idx = arr.length - 1; idx >= 0; idx--) {
17            for (int j = sum; j >= arr[idx]; j--) {
18                dp[j] = dp[j] | dp[j - arr[idx]];
19            }
20        }
21        return dp[sum];
22    }
23}