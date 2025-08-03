// Last updated: 4/8/2025, 12:00:33 am
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();// 2D list
		List<Integer> ll =new ArrayList<>();
        Arrays.sort(nums);
		subset(ans,ll,0,nums);
        return ans;
    }
    public static void subset(List<List<Integer>> ans, List<Integer> ll,int idx, int[]arr) {
		if(ll.size()<= arr.length) {
			ans.add(new ArrayList<>(ll));
			
		}
		for(int i=idx;i<arr.length;i++) {
            if(i>idx && arr[i]==arr[i-1])continue;
			ll.add(arr[i]);
			subset(ans,ll,i+1,arr);
			ll.remove(ll.size()-1);
		}
		
	}
}