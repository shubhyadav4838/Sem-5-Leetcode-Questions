// Last updated: 3/8/2025, 11:55:57 pm
class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] temp = new int[nums.length];
        int n = nums.length - 1;
        int i = 0;
        int j = nums.length-1;
        
        while(i <= j) {
            
            int a = nums[i];
            int b = nums[j];
            
            a = a * a;
            b = b * b;
            
            if(a > b) {
                temp[n] = a;
                i++;
            } else {
                temp[n] = b;
                j--;
            }
            
            n--;
        }
        
        
        return temp;
    }
}