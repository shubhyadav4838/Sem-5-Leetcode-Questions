// Last updated: 18/4/2026, 9:02:55 pm
1class Solution {
2    static public int mirrorDistance(int n) {
3        int rev=0;
4        for(int x=n; x>0; x/=10){
5            rev=10*rev+x%10;
6        }
7        return Math.abs(rev-n);
8    }
9}