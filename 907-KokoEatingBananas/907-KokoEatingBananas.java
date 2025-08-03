// Last updated: 3/8/2025, 11:56:24 pm
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long lo=1;
        long hi=0;
        long ans = Long.MAX_VALUE;
        for(int i=0;i<piles.length;i++){
            hi=Math.max(hi,piles[i]);
        }
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(ispossible(piles,h,mid)){
                hi=mid-1;
                ans=Math.min(ans,mid);
            }else{
                lo=mid+1;
            }
        }
        return (int)ans;
    }
    public static boolean ispossible(int[] arr,long h,long mid){
        long time = 0;
        for(int i=0;i<arr.length;i++){
            time+=arr[i]/mid;
            if(arr[i]%mid!=0)time++;
            
        }
        if(time>h)return false;
        return true;
    }
}