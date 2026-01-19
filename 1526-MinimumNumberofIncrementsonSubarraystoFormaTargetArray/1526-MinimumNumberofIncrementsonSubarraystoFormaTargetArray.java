// Last updated: 19/1/2026, 2:11:39 pm
1class Solution {
2    public int minNumberOperations(int[] target) {
3        int sum = target[0];
4        for(int i = 1;i<target.length;i++){
5            if(target[i]>target[i - 1]){
6                sum += target[i]- target[i - 1];
7            }
8        }
9        return sum;
10        
11    }
12}