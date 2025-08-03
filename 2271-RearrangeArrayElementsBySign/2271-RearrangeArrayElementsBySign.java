// Last updated: 3/8/2025, 11:54:00 pm

class Solution {
    public int[] rearrangeArray(int[] nums) {
       int []arr=new int[nums.length];
       int i=0;
       int j=1;
       for(int num:nums)
       {
         if(num>0)
         {
            arr[i]=num;
            i=i+2;
         }
         else
         {
            arr[j]=num;
            j=j+2;
         }
       }
        return arr;
    }
}