// Last updated: 9/3/2026, 8:42:32 am
1class Solution {
2    public int findContentChildren(int[] g, int[] s) {
3        Arrays.sort(g);
4        Arrays.sort(s);
5        int idx = 0;
6        int ans = 0;
7        for(int i = 0; i< g.length && idx < s.length; i++){
8            while(idx<s.length && s[idx]<g[i])idx++;
9            if(idx<s.length && g[i]<= s[idx])ans++;
10            idx++;
11        }
12
13        return ans;
14        
15    }
16}