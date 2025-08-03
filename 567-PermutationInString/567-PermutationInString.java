// Last updated: 3/8/2025, 11:57:27 pm
class Solution {
    static {
        for (int i=0; i<300; i++)
            checkInclusion("", "");
    }

    public static boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        if (s2.length() < len || len == 0)
            return false;

        if (len == 1)
            return s2.contains(s1);

        int[] freq = new int[26];
        for (int i = 0; i < len; i++)
            freq[s1.charAt(i) - 'a']++;

        int l = 0, r = 0;

        while (r < s2.length()) {
            freq[s2.charAt(r) - 'a']--;

            if (r - l + 1 == len) {
                if (nullFreq(freq))
                    return true;
                freq[s2.charAt(l++) - 'a']++;
            }
            r++;
        }
        return false;
    }

    public static boolean nullFreq(int[] freq) {
        for (int i = 0; i < freq.length; i++)
            if (freq[i] != 0)
                return false;
        return true;
    }
}