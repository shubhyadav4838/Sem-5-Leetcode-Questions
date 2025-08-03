// Last updated: 4/8/2025, 12:01:29 am
class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ll = new ArrayList();
		boolean[] isvisited = new boolean[arr.length];
		permutation(ans,ll,isvisited,arr);
        return ans;
        
    }
    public static void permutation(List<List<Integer>> ans,List<Integer> ll,boolean[] isvisited,int[] arr ) {
		if(ll.size()==arr.length) {
			ans.add(new ArrayList<>(ll));
			return ;
		}
		for(int i=0;i<arr.length;i++) {
			if(!isvisited[i]) {
				isvisited[i]=true;
				ll.add(arr[i]);
				permutation(ans,ll,isvisited,arr);
				isvisited[i]=false;
				ll.remove((ll.size()-1));
			}
		}
		
		
	}
}