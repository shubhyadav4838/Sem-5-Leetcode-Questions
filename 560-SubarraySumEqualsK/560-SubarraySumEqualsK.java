// Last updated: 3/8/2025, 11:57:31 pm
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer>mp = new HashMap<>();

        mp.put(0,1);

        int sum = 0;
        int count=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];

            if(mp.containsKey(sum-k)){
                count = count+mp.get(sum-k);
            }

            if(mp.containsKey(sum)){
                mp.put(sum,mp.get(sum)+1);
            }else
              mp.put(sum,1);
        }
        return count;
    }
}