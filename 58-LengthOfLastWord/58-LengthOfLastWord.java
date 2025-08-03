// Last updated: 4/8/2025, 12:01:11 am
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            else if (length > 0) {
                break;
            }
        }
        
        return length;
    }
}