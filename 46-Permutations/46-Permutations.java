// Last updated: 3/1/2026, 1:46:11 pm
1class Solution {
2    public List<List<Integer>> permute(int[] arr) {
3        List<Integer> ll = new ArrayList<>();
4		List<List<Integer>> ans = new ArrayList<>();
5		boolean[] visited = new boolean[arr.length];
6		solve(arr,ll,ans,visited);
7        return ans;
8    }
9    private static void solve(int[] arr, List<Integer> ll, List<List<Integer>> ans,
10			boolean[] visited) {
11		// TODO Auto-generated method stub
12		if(ll.size()==arr.length) {
13			ans.add(new ArrayList<>(ll));
14			return;
15		}
16		
17		for(int i = 0;i<arr.length;i++) {
18			if(!visited[i]) {
19				visited[i] = true;
20				ll.add(arr[i]);
21				solve(arr,ll,ans,visited);
22				ll.remove(ll.size()-1);
23				visited[i] = false;
24			}
25		}
26		
27	}
28}