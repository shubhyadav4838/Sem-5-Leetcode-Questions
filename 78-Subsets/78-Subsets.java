// Last updated: 4/8/2025, 12:00:46 am
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();// 2D list
		List<Integer> ll =new ArrayList<>();
		subset(ans,ll,0,nums);
        return ans;
    }
    public static void subset(List<List<Integer>> ans, List<Integer> ll,int idx, int[]arr) {
		if(ll.size()<= arr.length) {
			ans.add(new ArrayList<>(ll));
			
		}
		for(int i=idx;i<arr.length;i++) {
			ll.add(arr[i]);
			subset(ans,ll,i+1,arr);
			ll.remove(ll.size()-1);
		}
		
	}
}