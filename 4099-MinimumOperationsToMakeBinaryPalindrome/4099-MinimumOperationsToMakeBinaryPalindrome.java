// Last updated: 27/7/2026, 11:42:18 am
class Solution {
    public int[] minOperations(int[] arg0) {
        int[] ret = new int[arg0.length];
        int ptr = 0;
        for (int c : arg0) {
            int delta = 0;
            while (true) {
                int down = c - delta;
                int up = c + delta;
                if (down > 0 && check(down)) {
                    ret[ptr++] = delta;
                    break;
                }
                if (check(up)) {
                    ret[ptr++] = delta;
                    break;
                }
                delta++;
            }
        }
        return ret;
    }

    private boolean check(int v) {
        String s = Integer.toBinaryString(v);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}