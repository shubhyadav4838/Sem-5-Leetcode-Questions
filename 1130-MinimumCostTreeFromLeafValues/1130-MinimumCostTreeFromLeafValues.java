// Last updated: 28/1/2026, 6:43:41 pm
1class Solution {
2    public static int mctFromLeafValues(int[] arr) {
3        int n = arr.length;
4        Pair[][] dp = new Pair[n][n];
5        return solve(arr, 0, arr.length - 1, dp).sum;
6    }
7
8    private static Pair solve(int[] arr, int st, int ei, Pair[][] dp) {
9        if (st == ei) {
10            return new Pair(0, arr[st]);
11        }
12        if (dp[st][ei] != null) {
13            return dp[st][ei];
14        }
15
16        int minTotalSum = Integer.MAX_VALUE;
17        int currentMaxLeaf = 0;
18
19        for (int k = st; k < ei; k++) {
20            Pair left = solve(arr, st, k, dp);
21            Pair right = solve(arr, k + 1, ei, dp);
22
23            int rootVal = left.max * right.max;
24            int currentTotalSum = left.sum + right.sum + rootVal;
25
26            if (currentTotalSum < minTotalSum) {
27                minTotalSum = currentTotalSum;
28                currentMaxLeaf = Math.max(left.max, right.max);
29            }
30        }
31
32        return dp[st][ei] = new Pair(minTotalSum, currentMaxLeaf);
33    }
34
35    static class Pair {
36        int sum;
37        int max;
38
39        public Pair(int sum, int max) {
40            this.sum = sum;
41            this.max = max;
42        }
43    }
44}