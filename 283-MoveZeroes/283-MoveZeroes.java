// Last updated: 3/8/2025, 11:59:03 pm
class Solution {
    public void moveZeroes(int[] nums) {
       Move(nums); 
    }
    public void Move(int[]arr){
        int i=0;
        int j=1;
        while(j<arr.length){
            if(arr[i]==0 && arr[j]!=0){
                arr[i] = arr[j];
                arr[j] = 0;
                i++;
                j++;
            }
            if(i<arr.length && arr[i]!=0){
                i++;
            }
            if(j<arr.length && arr[j]==0){
                j++;
            }else if(j<=i){
                j++;
            }
        }
    }
}