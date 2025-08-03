// Last updated: 3/8/2025, 11:56:53 pm
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0){
            return 0;
        }
        int min1=0;
        int min2=cost[0];
        for(int i=1;i<cost.length;i++){
            int min=cost[i]+Math.min(min1,min2);
            min1=min2;
            min2=min;
        }
        return Math.min(min1,min2);
        
    }
}