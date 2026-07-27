// Last updated: 27/7/2026, 11:44:39 am
class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for(int i=2;i<s.length();i++){
            if(s.charAt(i-2)!= s.charAt(i-1) && s.charAt(i-1)!=s.charAt(i) && s.charAt(i-2)!=s.charAt(i)){
                count++;
            }
        }
        return count;
    }
}