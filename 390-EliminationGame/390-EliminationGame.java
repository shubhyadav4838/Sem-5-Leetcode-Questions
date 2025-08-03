// Last updated: 3/8/2025, 11:58:33 pm
class Solution {
    public int lastRemaining(int n) {
        if(n==1 || n==2)return n;
        return 2*(1+n/2-lastRemaining(n/2));
    }
}