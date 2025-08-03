// Last updated: 4/8/2025, 12:00:48 am
class Solution {
    public void sortColors(int[] nums) {
        insertion(nums);
    }
    public static void insertion(int[]arr){
        for(int i= 1; i<arr.length; i++){
            sort(arr,i);
        }

    }
    public static void sort(int[]arr, int i){
        int item = arr[i];
        int j = i-1;
        while(j>=0 && arr[j]>item){
        arr[j+1] = arr[j];
        arr[j] = item;
        j--;
        }
    }
}