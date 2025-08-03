// Last updated: 4/8/2025, 12:01:50 am
class Solution {
    public int divide(int dividend, int divisor) {
       return Divide(dividend,divisor);
    }
    public static int Divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
    boolean isNegative = (dividend < 0) ^ (divisor < 0);

    long n = Math.abs((long) dividend);
    long m = Math.abs((long) divisor);
    long result = 0;

    while (n >= m) {
        long temp = m;
        long multiple = 1;

        while (n >= (temp << 1)) {
            temp <<= 1;
            multiple <<= 1;
        }
        n -= temp;
        result += multiple;
    }
    result = isNegative ? -result : result;

    if (result > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
    }
    if (result < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
    }

    return (int) result;
}
}