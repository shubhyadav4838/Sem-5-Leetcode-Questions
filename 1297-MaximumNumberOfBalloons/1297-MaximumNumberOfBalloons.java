// Last updated: 27/7/2026, 11:45:56 am
class Solution {
    public int maxNumberOfBalloons(String s) {
        int[] freq = new int[26];
        String search = "balloon";
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int two = Math.min(freq['l'-'a'],freq['o'-'a']);
        int one = Math.min(freq['b'-'a'],Math.min(freq['a'-'a'],freq['n'-'a']));
        return Math.min(one,two/2);
        
    }
}