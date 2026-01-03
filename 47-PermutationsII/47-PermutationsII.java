// Last updated: 3/1/2026, 2:08:31 pm
1class Solution {
2    public List<List<Integer>> permuteUnique(int[] arr) {
3        List<Integer> ll = new ArrayList<>();
4		List<List<Integer>> ans = new ArrayList<>();
5		boolean[] visited = new boolean[arr.length];
6        Arrays.sort(arr);
7		solve(arr,ll,ans,visited);
8        return ans;
9    }
10
11    private static void solve(int[] arr, List<Integer> ll, List<List<Integer>> ans,
12			boolean[] visited) {
13		// TODO Auto-generated method stub
14		if(ll.size()==arr.length) {
15			ans.add(new ArrayList<>(ll));
16			return;
17		}
18		
19		for(int i = 0;i<arr.length;i++) {
20			if(i>0 && arr[i]==arr[i-1] && visited[i-1] == true)continue;
21			if(!visited[i]) {
22				visited[i] = true;
23				ll.add(arr[i]);
24				solve(arr,ll,ans,visited);
25				ll.remove(ll.size()-1);
26				visited[i] = false;
27			}
28		}
29		
30	}
31
32}