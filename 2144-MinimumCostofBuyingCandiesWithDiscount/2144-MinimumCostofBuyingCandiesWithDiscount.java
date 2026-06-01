// Last updated: 1/6/2026, 11:02:07 am
1class Solution {
2    public int minimumCost(int[] cost) {
3        Arrays.sort(cost);
4
5        int sum = 0;
6        int count = 0;
7        for(int i = cost.length-1;i>=0; i--){
8            if(count<2){
9                sum += cost[i];
10                count++;
11            }else{
12                count = 0;
13            }
14
15        }
16        return sum;
17        
18    }
19}