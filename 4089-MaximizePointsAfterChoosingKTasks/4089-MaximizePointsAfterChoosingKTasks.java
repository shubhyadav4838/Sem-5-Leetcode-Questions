// Last updated: 27/7/2026, 11:42:21 am
class Solution {
   public static long maxPoints(int[] a, int[] b, int c) {
    int s = a.length;
    long v = 0;
    int[] d = new int[s];
    int x = 0;
    while(x < s) {
        v += b[x];
        d[x] = a[x] - b[x];
        x++;
    }
    java.util.Arrays.sort(d);
    long res = v;
    int p = s - 1;
    while(c-- > 0) {
        res += d[p--];
    }
    while(p >= 0) {
        if(d[p] > 0) res += d[p--];
        else break;
    }
    return res;
}
}