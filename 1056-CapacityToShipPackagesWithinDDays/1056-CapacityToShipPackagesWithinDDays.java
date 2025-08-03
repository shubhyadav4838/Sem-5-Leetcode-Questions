// Last updated: 3/8/2025, 11:55:42 pm
class Solution {
    public int shipWithinDays(int[] weights, int d) {
        int lo=1;
        int hi=0;
        int ans=Integer.MAX_VALUE;
        for(int s:weights){
            hi+=s;
        }
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(mid,weights,d)){
                ans=Math.min(ans,mid);
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int mid,int[] arr,int d){
        int t=1;
        int w = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid)return false;
            if(w+arr[i]>mid){
                t++;
                w=arr[i];
                if(d<t)return false;
            }else{
                w+=arr[i];
            }
        }
        return true;
    }
}