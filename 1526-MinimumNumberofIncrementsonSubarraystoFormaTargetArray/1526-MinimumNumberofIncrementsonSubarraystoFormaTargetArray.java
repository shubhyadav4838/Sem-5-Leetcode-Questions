// Last updated: 18/3/2026, 11:02:22 pm
1class Solution {
2    public int minNumberOperations(int[] target) {
3        if(target.length==1){
4            return target[0];
5        }
6        int sum = 0;
7        for(int i = 1;i<target.length; i++){
8            if(target[i]>target[i-1]){
9                sum += (target[i]-target[i-1]);
10            }
11        }
12        // if(target[0]>target[1]){
13        //     sum += (target[0]-target[1])+1;
14        // }else{
15            sum += target[0];
16        // }
17        return sum;
18    }
19}