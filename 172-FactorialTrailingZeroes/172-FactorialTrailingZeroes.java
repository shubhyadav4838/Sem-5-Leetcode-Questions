// Last updated: 3/8/2025, 11:59:49 pm
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
    return res;
    }
}