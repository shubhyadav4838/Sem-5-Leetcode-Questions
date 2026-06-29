// Last updated: 29/6/2026, 12:44:48 pm
1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3
4        int ans = 0;
5
6        for (String str : patterns) {
7            if (word.indexOf(str) != -1) {
8
9                ans++;
10            }
11        }
12
13        return ans;
14    }
15}