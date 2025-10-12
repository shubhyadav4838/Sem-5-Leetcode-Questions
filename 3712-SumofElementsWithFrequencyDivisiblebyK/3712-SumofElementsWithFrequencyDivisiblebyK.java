// Last updated: 12/10/2025, 11:45:57 pm
class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] freq = new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int sum = 0;
        for(int i = 0;i<freq.length;i++){
            if(freq[i]%k==0){
                sum+=i*freq[i];
            }
        }
        return sum;
        
    }
}