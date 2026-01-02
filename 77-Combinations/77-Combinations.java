// Last updated: 2/1/2026, 3:57:07 pm
1class Solution {
2    public List<List<Integer>> combine(int n, int k) {
3        List<Integer> ll = new ArrayList<>();
4		List<List<Integer>> ans = new ArrayList<>();
5		solve( n, 1, k, ll, ans);
6        return ans;
7    }
8    private static void solve(int n, int cur, int k, List<Integer> ll, List<List<Integer>> ans) {
9		// TODO Auto-generated method stub
10		if(ll.size()>k)return;
11		if(ll.size()==k) {
12			ans.add(new ArrayList<>(ll));
13			return;
14		}
15		
16		for(int i = cur; i<=n;i++) {
17			ll.add(i);
18			solve(n,i+1,k,ll,ans);
19			ll.remove(ll.size()-1);
20		}
21		
22	}
23}