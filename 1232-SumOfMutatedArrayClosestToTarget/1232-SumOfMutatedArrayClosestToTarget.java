// Last updated: 3/8/2025, 11:55:20 pm
class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr[arr.length-1];
        int ans = hi;
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            int temp = ekFunction(arr,mid);
            int currDiff=Math.abs(target-temp);
            if(currDiff<diff || (currDiff==diff && mid<ans)){
                ans=mid;
                diff=currDiff;
            }
            if(temp<target){
                lo=mid+1;
            }else {
                hi=mid-1;
            }
        }

        return ans;
    }
    public static int ekFunction(int[] arr, int val){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<val)sum+=arr[i];
            else {
                sum+=(arr.length-i)*val;
                break;
            }
        }
        return sum;
    }  
}