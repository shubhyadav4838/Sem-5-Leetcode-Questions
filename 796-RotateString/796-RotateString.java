// Last updated: 3/5/2026, 9:18:15 pm
1class Solution {
2    public boolean rotateString(String s, String goal) {
3        int n = s.length();
4        if (n != goal.length()) return false;
5        
6        int[][] dfa = new int[n][26];
7        dfa[0][s.charAt(0) - 'a'] = 1;
8        
9        int x = 0;
10        for (int i = 1; i < n; i++) {
11            for (int j = 0; j < 26; j++)
12                dfa[i][j] = dfa[x][j];
13            int c = s.charAt(i) - 'a';
14            dfa[i][c] = i + 1;
15            x = dfa[x][c];
16        }
17        
18        int state = 0;
19        for (int i = 0; i < n << 1; i++) {
20            state = dfa[state][goal.charAt(i % n) - 'a'];
21            if (state == n) return true;
22        }
23        
24        return false;
25    }
26}