// Last updated: 27/7/2026, 11:45:52 am
class Solution {
    public boolean isGoodArray(int[] nums) {
        int result = nums[0];
        
        for (int num : nums) {
            result = gcd(result, num);
            
            if (result == 1) {
                return true;
            }
        }
        
        return result == 1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}