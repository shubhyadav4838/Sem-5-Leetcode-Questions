// Last updated: 6/12/2025, 9:02:59 pm
1class Solution {
2    public int[] minOperations(int[] arg0) {
3        int[] ret = new int[arg0.length];
4        int ptr = 0;
5        for (int c : arg0) {
6            int delta = 0;
7            while (true) {
8                int down = c - delta;
9                int up = c + delta;
10                if (down > 0 && check(down)) {
11                    ret[ptr++] = delta;
12                    break;
13                }
14                if (check(up)) {
15                    ret[ptr++] = delta;
16                    break;
17                }
18                delta++;
19            }
20        }
21        return ret;
22    }
23
24    private boolean check(int v) {
25        String s = Integer.toBinaryString(v);
26        int i = 0, j = s.length() - 1;
27        while (i < j) {
28            if (s.charAt(i++) != s.charAt(j--)) return false;
29        }
30        return true;
31    }
32}