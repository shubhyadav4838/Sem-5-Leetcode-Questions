// Last updated: 24/4/2026, 10:14:51 pm
1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int l = 0;
4        int r = 0;
5        int space = 0;
6        for(char s:moves.toCharArray()){
7            if(s=='L')l++;
8            else if(s=='R')r++;
9            else space++;
10        }
11
12        return Math.abs(l-r)+space;
13        
14    }
15}