// Last updated: 5/4/2026, 10:50:27 am
1class Solution {
2    public boolean isMatch(String s, String p) {
3        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
4        return solve(s, p, 0, 0, dp);
5    }
6
7    public boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
8        if (j == p.length()) {
9            return i == s.length();
10        }
11
12        if (dp[i][j] != null) {
13            return dp[i][j];
14        }
15
16        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
17
18        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
19            dp[i][j] = solve(s, p, i, j + 2, dp) || (match && solve(s, p, i + 1, j, dp));
20        } else {
21            dp[i][j] = match && solve(s, p, i + 1, j + 1, dp);
22        }
23
24        return dp[i][j];
25    }
26}