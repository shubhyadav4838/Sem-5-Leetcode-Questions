// Last updated: 3/6/2026, 1:51:36 pm
1class Solution {
2    public static int earliestFinishTime(int[] lstart, int[] ldur, int[] wstart, int[] wdur) {
3		int max = Integer.MAX_VALUE;
4        int land = max, water = max, minl = max, minw = max;
5        int n = lstart.length, m = wstart.length;
6        for(int i = 0; i<n; i++){
7            land = Math.min(land,lstart[i]+ldur[i]);
8        }
9
10        for(int i=0;i<m; i++){
11            water = Math.min(water,wstart[i]+wdur[i]);
12            minl = Math.min(minl, Math.max(land,wstart[i])+wdur[i]);
13        }
14
15        for(int i =0;i<n; i++){
16            minw = Math.min(minw,Math.max(water,lstart[i])+ldur[i]);
17        }
18
19        return Math.min(minw,minl);
20
21	}
22}