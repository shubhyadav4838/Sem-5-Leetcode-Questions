// Last updated: 4/8/2025, 12:01:08 am
class Solution {
    public String getPermutation(int n, int k) {
        count=0;
        int[] arr = new int[n];
        for(int i=1;i<=arr.length;i++){
            arr[i-1]=i;
        }
		List<String> ans = new ArrayList<>();
		StringBuilder ll = new StringBuilder();
		boolean[] isvisited = new boolean[arr.length];
		permutation(ans,ll,isvisited,arr,k);
        return ans.get(0);
    }
    static int count =0;
	public static void permutation(List<String> ans,StringBuilder ll,boolean[] isvisited,int[] arr,int k ) {
		if(ll.length()==arr.length) {
			count++;
			if(count==k) {
				ans.add(ll.toString());
				
			}
			return ;
		}
		for(int i=0;i<arr.length;i++) {
			if(!isvisited[i]) {

				isvisited[i]=true;
				ll.append(arr[i]);
				
				permutation(ans,ll,isvisited,arr,k);
				if(count==k)return;
				isvisited[i]=false;
				ll.deleteCharAt(ll.length() - 1);
			}
		}
    }
		
}