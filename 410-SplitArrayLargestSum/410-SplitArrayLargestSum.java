// Last updated: 3/8/2025, 11:58:27 pm
class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = 0;
        for(int i = 0; i<nums.length; i++){
            h+=nums[i];
        }
        int n = nums.length;
        int ans = h;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(Isvalid(nums,k,mid)){
                h = mid-1;
                ans = Math.min(ans,mid);
            }else{
                l = mid+1;
            }

        }
        return ans;
        
    }
    public static boolean Isvalid(int[]arr,int k ,int max){
        int student = 1;
        int pages = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>max){
                return false;
            }
            if(pages+arr[i]<=max){
                pages+=arr[i];
            }else{
                student++;
                pages = arr[i];
            }
        }
        return student>k?false:true;
    }

}