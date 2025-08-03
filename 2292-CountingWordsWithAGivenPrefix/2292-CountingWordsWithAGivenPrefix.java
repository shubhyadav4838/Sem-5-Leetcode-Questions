// Last updated: 3/8/2025, 11:53:59 pm
class Solution {
    public int prefixCount(String[] words, String pref) {
        int c = 0;
        int n = pref.length();
        for (String w : words) {
            if (w.length() >= n && w.startsWith(pref)) {
                c++;
            }
        }
        return c;
        
    }
}