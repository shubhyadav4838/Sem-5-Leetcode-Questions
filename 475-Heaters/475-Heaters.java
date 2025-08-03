// Last updated: 3/8/2025, 11:57:50 pm
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        return house(houses,heaters);
    }
    public static int house(int[] arr, int[] heater){
        Arrays.sort(arr);
        Arrays.sort(heater);
        int ans = Integer.MAX_VALUE;
        int lo = 0;
        int hi = Math.max(arr[arr.length-1],heater[heater.length-1])-Math.min(arr[0],heater[0]);
        ans = hi;
        while(lo<=hi){
            int mid = lo+((hi-lo)/2);
            if(ispossible(arr,heater,mid)){
                hi=mid-1;
                ans = Math.min(ans,mid);
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
    public static boolean ispossible(int[] arr, int[] heater,int mid){
        int idx = 0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]<heater[idx]-mid )return false;
            else if(arr[i]>heater[idx]+mid){
                idx++;
                i--;
            }
            if(idx==heater.length)return false;
        }
        return true;
    }
}