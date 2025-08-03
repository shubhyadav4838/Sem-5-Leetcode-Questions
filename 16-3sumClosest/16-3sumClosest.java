// Last updated: 4/8/2025, 12:02:11 am
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        return threeSum(nums, target);
    }
    public int threeSum(int[]arr, int target){
        Arrays.sort(arr);
        int neg = Integer.MAX_VALUE;
        int pos = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for(int k=0;k<arr.length-2;k++){
            int i = k+1;
            int j = arr.length-1;
            while(i<j){
                int sum = arr[k]+arr[i]+arr[j];
                 int n = Math.abs(target-sum);
                    if(n<diff){
                        ans = sum;
                        diff = n;
                    }
                if(sum<target){
                    i++;
                }else if(sum>target){
                    j--;
                }else{
                    return target;
                }
            }
        }
        
        return ans;
    }
}