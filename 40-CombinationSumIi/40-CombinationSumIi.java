// Last updated: 4/8/2025, 12:01:35 am
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();// 2D list
		List<Integer> ll =new ArrayList<>();
        Arrays.sort(candidates);
		Combination(candidates,target,ans,ll,0);
        return ans;
        
    }
    public static void Combination(int[]coin, int amount,List<List<Integer>> ans,List<Integer> ll, int idx) {
		if(amount ==0) {
			ans.add(new ArrayList<>(ll));// Create new array list and copy its data 
			return;
		}
		for(int i=idx;i<coin.length;i++) {
            if(i>idx && coin[i]==coin[i-1])continue;
			if(amount>=coin[i]) {
				ll.add(coin[i]);
				Combination(coin,amount-coin[i],ans,ll,i+1);
				ll.remove(ll.size()-1);
			}
		}
	}
    public static boolean isvalid(int n, int i,int[]arr){
        for(int j=i;j<arr.length;j++){
            if(arr[j]==n){
                return true;
            }
        }
        return false;
    }
}