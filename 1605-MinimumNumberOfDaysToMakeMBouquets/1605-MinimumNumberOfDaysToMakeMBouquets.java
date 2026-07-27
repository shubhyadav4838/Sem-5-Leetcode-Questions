// Last updated: 27/7/2026, 11:45:18 am
class Solution {
    public int minDays(int[] arr, int boq, int flo) {
        int lo = 0;
        int hi = 0;
        for(int x:arr){
            hi = Math.max(hi,x);
        }
        int ans = 0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(isPossible(arr,boq,flo,mid)){
                ans = mid;
                hi = mid-1;

            }else{
                lo = mid+1;
            }

        }
        return (ans==0 ? -1 : ans);
    }

    public boolean isPossible(int[] arr, int boq, int flow, int mid){
        int bcount = 0;
        int fcount = 0;
        for(int i=0;i<arr.length; i++){
            if(arr[i]<=mid){
                fcount++;
                if(fcount==flow){
                    bcount++;
                    fcount = 0;
                }
            }else{
                fcount = 0;
            }

            if(bcount>=boq){
                return true;
            }
        }
        return false;

    

    }
}