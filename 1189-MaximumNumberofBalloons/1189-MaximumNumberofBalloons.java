// Last updated: 22/6/2026, 9:22:59 am
1class Solution {
2    public int maxNumberOfBalloons(String s) {
3        int[] freq = new int[26];
4        String search = "balloon";
5        for(char ch:s.toCharArray()){
6            freq[ch-'a']++;
7        }
8        int two = Math.min(freq['l'-'a'],freq['o'-'a']);
9        int one = Math.min(freq['b'-'a'],Math.min(freq['a'-'a'],freq['n'-'a']));
10        return Math.min(one,two/2);
11        
12    }
13}