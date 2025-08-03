// Last updated: 3/8/2025, 11:52:53 pm
class Solution {
    public int[] transformArray(int[] nums) {
        return parityArray(nums);
    }
    public static int[] parityArray(int[] arr){
        int [] ans = new int[arr.length];
        int even = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                even++;
            }
        }
        for(int i = even;i<ans.length;i++){
            ans[i]=1;
        }
        return ans;
    }
}