// Last updated: 27/7/2026, 11:42:16 am

class Solution {
    static boolean[] g;
    
    static void gg() {
        int m = 1000001;
        g = new boolean[m];
        Arrays.fill(g, true);
        g[0] = false;
        g[1] = false;
        for (int i = 2; i * i < m; i++) {
            if (g[i]) {
                for (int j = i * i; j < m; j += i)
                    g[j] = false;
            }
        }
    }

    public static boolean completePrime(int x) {
        if (g == null) gg();
        
        if (x >= 1000001 || x < 2) return false;
        
        String s = Integer.toString(x);
        int len = s.length();
        
        int i = 1;
        while (i <= len) {
            if (!g[Integer.parseInt(s.substring(0, i))]) return false;
            i++;
        }
        
        int j = 0;
        while (j < len) {
            if (!g[Integer.parseInt(s.substring(j))]) return false;
            j++;
        }
        
        return true;
    }
}