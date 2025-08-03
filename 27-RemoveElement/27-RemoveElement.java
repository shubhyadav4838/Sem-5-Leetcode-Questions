// Last updated: 4/8/2025, 12:01:54 am
class Solution {
    public int removeElement(int[] nums, int val) {
        return remove(nums,val);
    }
    public int remove(int[]arr, int val){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]==val && arr[j]!=val){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
            if(arr[i]!=val){
                i++;
            }
            if(arr[j]==val){
                j--;
            }
        }
        int ans = 0;
        for(int k=0; k<arr.length; k++){
            if(arr[k]==val){
                ans = k;
                break;
            }else{
                ans=k+1;
            }
        }
       
        return ans;
    }
}