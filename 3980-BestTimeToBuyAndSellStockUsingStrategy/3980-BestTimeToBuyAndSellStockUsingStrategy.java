// Last updated: 23/8/2025, 6:59:14 pm
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] right =new long[n];
        right[n-1] = prices[n-1]*strategy[n-1];
        
        
        for(int i=prices.length-2;i>=0;i--){
            right[i]=(prices[i]*strategy[i])+right[i+1];
        }
        long[]left = new long[n];
        left[0] = prices[0]*strategy[0];
        long[]one = new long[n];
        one[0] = prices[0]*1;
        for(int i=1;i<n;i++){
            left[i] = (prices[i]*strategy[i])+left[i-1];
            one[i] = prices[i]+one[i-1];
        }
        long ans = Long.MIN_VALUE;
        int val = k/2;
        for(int i=0;i+k-1<n;i++){
            long sum = 0;
            if(i-1>=0){
                sum+=left[i-1];
            }
            if(i+k<n){
                sum+=right[i+k];
            }
            sum+=one[i+k-1]-one[i+val-1];
            ans = Math.max(sum,ans);
        }
        return Math.max(ans,left[n-1]);
        
        
        
    }
}