// Last updated: 27/7/2026, 11:45:19 am
class Solution {
    public int minNumberOperations(int[] target) {
        if(target.length==1){
            return target[0];
        }
        int sum = 0;
        for(int i = 1;i<target.length; i++){
            if(target[i]>target[i-1]){
                sum += (target[i]-target[i-1]);
            }
        }
        
            sum += target[0];
      
        return sum;
    }
}