// Last updated: 3/1/2026, 10:55:40 am
1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<Integer> ll = new ArrayList<>();
4		List<List<Integer>> ans = new ArrayList<>();
5		
6		solve(nums,0,ll,ans);
7        return ans;
8    }
9    private static void solve(int[] arr, int idx, List<Integer> ll, List<List<Integer>> ans) {
10		// TODO Auto-generated method stub
11		ans.add(new ArrayList<>(ll));
12		if(idx==arr.length) {
13			return;
14		}
15		
16		
17		
18		for(int i = idx; i<arr.length;i++) {
19			ll.add(arr[i]);
20			solve(arr,i+1,ll,ans);
21			ll.remove(ll.size()-1);
22		}
23		
24	}
25}