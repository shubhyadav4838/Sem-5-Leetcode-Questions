// Last updated: 29/3/2026, 1:59:51 pm
1class Solution {
2    public int wiggleMaxLength(int[] arr) {
3        if (arr.length <= 1) return arr.length;
4        
5        Integer[][] dp = new Integer[arr.length][2];
6        
7        int startWithUp = 1 + solve(1, 1, arr, dp);
8        int startWithDown = 1 + solve(1, 0, arr, dp);
9        
10        return Math.max(startWithUp, startWithDown);
11    }
12
13    private int solve(int i, int expectingUp, int[] arr, Integer[][] dp) {
14        if (i == arr.length) {
15            return 0; 
16        }
17        
18        if (dp[i][expectingUp] != null) {
19            return dp[i][expectingUp];
20        }
21        
22        int skip = solve(i + 1, expectingUp, arr, dp);
23        
24        int take = 0;
25        if (expectingUp == 1 && arr[i] > arr[i - 1]) {
26            take = 1 + solve(i + 1, 0, arr, dp);
27        } 
28        else if (expectingUp == 0 && arr[i] < arr[i - 1]) {
29            take = 1 + solve(i + 1, 1, arr, dp);
30        }
31        
32        return dp[i][expectingUp] = Math.max(skip, take);
33    }
34}