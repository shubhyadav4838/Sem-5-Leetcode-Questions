// Last updated: 4/8/2025, 12:02:21 am
public class Solution {  
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        long ans = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                ans = ans * 10 + (ch - '0');
                if (ans > Integer.MAX_VALUE && sign == -1) {
                    return Integer.MIN_VALUE;
                } else if (ans > Integer.MAX_VALUE && sign == 1) {
                    return Integer.MAX_VALUE;
                }
                i++;
            } else {
                break;
            }
        }
        return (int) (ans * sign);
    }
}
