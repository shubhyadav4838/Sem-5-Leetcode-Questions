// Last updated: 2/1/2026, 11:18:43 pm
1class Solution {
2    public List<List<Integer>> combinationSum(int[] arr, int target) {
3        List<Integer> ll = new ArrayList<>();
4		List<List<Integer>> ans = new ArrayList<>();
5
6		solve(arr, 0,0, target, ll, ans);
7        return ans;
8    }
9    private static void solve(int[] arr, int cur,int idx, int sum, List<Integer> ll, List<List<Integer>> ans) {
10		// TODO Auto-generated method stub
11		if(cur==sum) {
12			ans.add(new ArrayList<>(ll));
13			return;
14		}
15		if(idx==arr.length || cur>sum) {
16			return;
17		}
18
19		
20		for(int i = idx; i<arr.length;i++) {
21			if(cur+arr[i]<=sum) {
22				ll.add(arr[i]);
23				solve(arr,cur+arr[i],i,sum,ll,ans);
24				ll.remove(ll.size()-1);
25			}	
26		}	
27	}
28}