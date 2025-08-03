// Last updated: 4/8/2025, 12:00:47 am
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer>ll = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		combination(ll,ans,n,k,1);
        return ans;
    }
    public static void combination(List<Integer>ll, List<List<Integer>> ans,int n, int k, int idx ) {
		if(ll.size()==k) {
			ans.add(new ArrayList<>(ll));
			return;
		}
		for(int i=idx;i<=n;i++) {
			ll.add(i);
			combination(ll,ans,n,k,i+1);
			ll.remove(ll.size()-1);
		}
	}
}