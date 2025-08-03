// Last updated: 3/8/2025, 11:54:31 pm
class Solution {
    public int maximumScore(int a, int b, int c) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (c > a) {
            int temp = a;
            a = c;
            c = temp;
        }
        if (b < c) {
           int temp = b;
            b = c;
            c = temp;
        }
        return Math.min(a + b + c - Math.max(a, Math.max(b, c)), (a + b + c) / 2);
    }
}