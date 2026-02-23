// Last updated: 23/2/2026, 7:02:19 pm
1class Solution {
2    public boolean canPartition(int[] arr) {
3        int sum = 0;
4        for (int x : arr) {
5            sum += x;
6        }
7        if (sum % 2 != 0) {
8            return false;
9        }
10        sum = sum / 2;
11        boolean[] dp = new boolean[sum + 1];
12        dp[0] = true;
13        System.out.println(sum);
14        for (int i = 0; i < arr.length; i++) {
15            for (int am = sum; am >= arr[i]; am--) {
16                if (dp[am - arr[i]] == true) {
17                    dp[am] = true;
18                }
19            }
20           
21        }
22
23        return dp[dp.length - 1];
24
25    }
26}