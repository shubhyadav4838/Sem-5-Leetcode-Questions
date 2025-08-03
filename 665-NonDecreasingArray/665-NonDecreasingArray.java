// Last updated: 3/8/2025, 11:57:09 pm
class Solution {
    public boolean checkPossibility(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                boolean ans = ispossible(i-1,arr);
                if(ans)return true;
                else {
                    arr[i]=temp;
                    arr[i+1] = temp;
                    boolean val = ispossible(i-1,arr);
                    if(val)return true;
                    return false;
                }
               
            }
           

        }
        return true;
        
    }
    public static boolean ispossible(int i,int[] arr){
        if(i<0)i=0;
        for(;i<arr.length-1;i++){
            if(arr[i]>arr[i+1])return false;
        }
        return true;
    }
}