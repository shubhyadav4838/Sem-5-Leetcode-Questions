// Last updated: 3/8/2025, 11:55:44 pm
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int [] count = new int[60];
        int ans = 0;
        for(int t : time){
            t%=60;
            ans+=count[(60-t)%60];
            count[t]++;
        }
        return ans;
    }
}