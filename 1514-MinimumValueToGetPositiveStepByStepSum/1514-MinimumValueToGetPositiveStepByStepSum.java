// Last updated: 3/8/2025, 11:54:59 pm
class Solution {
    public int minStartValue(int[] nums) {
        return startValue(nums);
    }
    public static int startValue(int[] arr){
        // if(arr.length==1){
        //     if(arr[0]<1){
        //         return 1-arr[0];
        //     }
        //     return 1;
        // }
        int start = 1;
        int minimum = Integer.MAX_VALUE;
        for(int x:arr){
            start+=x;
            minimum=Math.min(minimum,start);

        }
        if(minimum<1){
            return 1-minimum+1;
        }
        return 1;
    }
}