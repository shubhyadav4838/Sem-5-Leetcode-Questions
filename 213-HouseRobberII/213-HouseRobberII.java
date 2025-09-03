// Last updated: 3/9/2025, 10:56:47 pm
class Solution {
    public int rob(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        
        int first = robHouse(arr,0,arr.length-1);
        int second = robHouse(arr,1,arr.length);
        return Math.max(first,second);
        
        
    }
    public int robHouse(int[] arr,int start, int end){
        int[] dp = new int[arr.length];
        if(start == 1){
            arr[0] = 0;
        }
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<end;i++){
            int rob = dp[i-2]+arr[i];
            int dont = dp[i-1];
            dp[i] = Math.max(rob,dont);
            
        }
        if(end==arr.length){
            return dp[dp.length-1];
        }
        return dp[dp.length-2];

    }
    
}