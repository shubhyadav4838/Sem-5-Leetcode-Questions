// Last updated: 4/8/2025, 12:00:59 am
class Solution {
    public int[] plusOne(int[] digits) {
        return plus(digits);
    }
    public int[] plus(int []arr){
        // arr[arr.length-1]+=1;
        int carry = 1;
        for(int i=arr.length-1;i>=0; i--){
            if(arr[i]+carry==10){
                arr[i] = 0;
            }else{
                arr[i]+=carry;
                carry = 0;
            }
        }
        
        if(carry == 1){
            int[] res = new int[arr.length+1];
            res[0] = 1;
            for(int i=1;i<res.length; i++){
                res[i] = arr[i-1];
            }
            return res;
        }
        return arr;
    }
}