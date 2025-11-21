// Last updated: 21/11/2025, 3:31:34 pm
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        return occur(nums,queries,x);
    }
    public int[] occur(int[] nums, int[] queries, int x){
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == x) {
                indexs.add(i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            if(queries[i]-1 < indexs.size()) {
                res[i] = indexs.get(queries[i]-1);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}