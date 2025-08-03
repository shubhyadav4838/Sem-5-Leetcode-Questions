// Last updated: 3/8/2025, 11:53:51 pm
class Solution {
    public long coloredCells(int n) {
        long sum = 1;
        for(int i=0;i<n;i++){
            sum+=4*i;
        }
        return sum;
    }
}