// Last updated: 3/8/2025, 11:59:34 pm
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>ll = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		combination(ll,ans,9,k,1,n);
        return ans;
    }
    public static void combination(List<Integer>ll, List<List<Integer>> ans,int n, int k, int idx,int sum ) {
		if(ll.size()==k && sum==0) {
			ans.add(new ArrayList<>(ll));
			return;
		}
		if(ll.size()>k || sum<0) {
			return;
		}
		for(int i=idx;i<=n;i++) {
			ll.add(i);
			combination(ll,ans,n,k,i+1,sum-i);
			ll.remove(ll.size()-1);
		}
	}
}