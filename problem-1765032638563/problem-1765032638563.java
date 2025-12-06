// Last updated: 6/12/2025, 8:20:38 pm
1
2class Solution {
3    static boolean[] g;
4    
5    static void gg() {
6        int m = 1000001;
7        g = new boolean[m];
8        Arrays.fill(g, true);
9        g[0] = false;
10        g[1] = false;
11        for (int i = 2; i * i < m; i++) {
12            if (g[i]) {
13                for (int j = i * i; j < m; j += i)
14                    g[j] = false;
15            }
16        }
17    }
18
19    public static boolean completePrime(int x) {
20        if (g == null) gg();
21        
22        if (x >= 1000001 || x < 2) return false;
23        
24        String s = Integer.toString(x);
25        int len = s.length();
26        
27        int i = 1;
28        while (i <= len) {
29            if (!g[Integer.parseInt(s.substring(0, i))]) return false;
30            i++;
31        }
32        
33        int j = 0;
34        while (j < len) {
35            if (!g[Integer.parseInt(s.substring(j))]) return false;
36            j++;
37        }
38        
39        return true;
40    }
41}