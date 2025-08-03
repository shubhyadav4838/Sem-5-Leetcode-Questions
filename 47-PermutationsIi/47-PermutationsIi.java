// Last updated: 4/8/2025, 12:01:28 am
class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
         List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ll = new ArrayList();
		boolean[] isvisited = new boolean[arr.length];
        Arrays.sort(arr);
		permutation(ans,ll,isvisited,arr);
        return ans;
    }
     public static void permutation(List<List<Integer>> ans,List<Integer> ll,boolean[] isvisited,int[] arr ) {
		if(ll.size()==arr.length) {
			ans.add(new ArrayList<>(ll));
			return ;
		}
		for(int i=0;i<arr.length;i++) {
			if(!isvisited[i] ) {
                if(i>0 && arr[i-1]==arr[i] && isvisited[i-1])continue;
				isvisited[i]=true;
				ll.add(arr[i]);
				permutation(ans,ll,isvisited,arr);
				isvisited[i]=false;
				ll.remove((ll.size()-1));
			}
		}
		
		
	}
}