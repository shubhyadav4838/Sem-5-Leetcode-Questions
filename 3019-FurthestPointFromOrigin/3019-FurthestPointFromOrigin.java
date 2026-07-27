// Last updated: 27/7/2026, 11:43:40 am
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int space = 0;
        for(char s:moves.toCharArray()){
            if(s=='L')l++;
            else if(s=='R')r++;
            else space++;
        }

        return Math.abs(l-r)+space;
        
    }
}