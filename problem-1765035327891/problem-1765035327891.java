// Last updated: 6/12/2025, 9:05:27 pm
1class Solution {
2   public static long maxPoints(int[] a, int[] b, int c) {
3    int s = a.length;
4    long v = 0;
5    int[] d = new int[s];
6    int x = 0;
7    while(x < s) {
8        v += b[x];
9        d[x] = a[x] - b[x];
10        x++;
11    }
12    java.util.Arrays.sort(d);
13    long res = v;
14    int p = s - 1;
15    while(c-- > 0) {
16        res += d[p--];
17    }
18    while(p >= 0) {
19        if(d[p] > 0) res += d[p--];
20        else break;
21    }
22    return res;
23}
24}