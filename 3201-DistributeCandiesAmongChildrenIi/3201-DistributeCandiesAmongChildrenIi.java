// Last updated: 3/8/2025, 11:53:36 pm
class Solution {
    public long distributeCandies(int n, int limit) {
        return co(n) - (3 * co(n - (limit + 1))) +( 3 * co(n - 2 * (limit + 1))) - (co(n - 3 * (limit + 1)));


    }
    public long co(long n){
        if(n<0)return 0;
        return (long)(n+1)*(n+2)/2;
    }
}