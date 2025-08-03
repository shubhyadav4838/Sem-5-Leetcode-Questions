// Last updated: 3/8/2025, 11:58:06 pm
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i, j = 0;
        int[] temp = new int[nums.length];
        for(i = 0; i < nums.length; i++)
        {
            j = nums[i];
            temp[j-1] = -1;
        }
        for(i = 0; i < nums.length; i++)
        {
            if(temp[i] == 0)
                res.add(i+1);
        }
        return res;
    }
}