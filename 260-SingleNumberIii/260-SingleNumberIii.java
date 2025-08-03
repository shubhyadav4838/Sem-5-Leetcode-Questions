// Last updated: 3/8/2025, 11:59:14 pm
class Solution {
    public int[] singleNumber(int[] nums) {
        int [] ans = new int[2];
        int xor = 0;
        for(int i : nums)xor^=i;

        int lowerbits = xor & -xor;
        // System.out.print(xor+" "+(-xor));

        for(int i: nums){
            if((i & lowerbits) == 0) ans[0]^=i;
            else ans[1]^=i;
        }
        return ans;
    }
}