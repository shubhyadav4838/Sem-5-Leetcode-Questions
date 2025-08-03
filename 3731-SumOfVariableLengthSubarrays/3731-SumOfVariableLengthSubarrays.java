// Last updated: 3/8/2025, 11:53:00 pm
class Solution {
    public int subarraySum(int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            int st = Math.max(0,i-arr[i]);
            for(;st<=i;st++){
                sum+=arr[st];
            }
        }
        return sum;
    }
}