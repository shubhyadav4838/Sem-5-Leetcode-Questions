// Last updated: 3/8/2025, 11:59:09 pm
class Solution {
    public int missingNumber(int[] nums) {
        return Number(nums);
    }
    public int Number(int[]arr){
        if(arr.length==1){
            if(arr[0]==1){
                return 0;
            }else return arr[0]+1;
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]+1!=arr[i+1]){
                return arr[i]+1;
            }
        }
        if(arr[0]!=0){
            return 0;
        }
        return arr[arr.length-1]+1;
    }
}