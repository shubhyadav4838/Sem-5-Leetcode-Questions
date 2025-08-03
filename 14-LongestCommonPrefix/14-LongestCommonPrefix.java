// Last updated: 4/8/2025, 12:02:13 am
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if ( strs.length == 0)
           return "";
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    
    }
}