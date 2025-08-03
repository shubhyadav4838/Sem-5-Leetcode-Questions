// Last updated: 3/8/2025, 11:55:41 pm
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int best=values[0],max=0;

        for(int i=1;i<values.length;i++){
            max=Math.max(max,values[i]+best-i);
            best=Math.max(best,values[i]+i);
        }
        return max;
    }
}