// Last updated: 3/1/2026, 12:01:45 am
1class Solution {
2    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
3        List<List<Integer>> ans = new ArrayList<>();// 2D list
4		List<Integer> ll =new ArrayList<>();
5        Arrays.sort(candidates);
6		Combination(candidates,target,ans,ll,0);
7        return ans;
8        
9    }
10    public static void Combination(int[]coin, int amount,List<List<Integer>> ans,List<Integer> ll, int idx) {
11		if(amount ==0) {
12			ans.add(new ArrayList<>(ll));// Create new array list and copy its data 
13			return;
14		}
15		for(int i=idx;i<coin.length;i++) {
16            if(i>idx && coin[i]==coin[i-1])continue;
17			if(amount>=coin[i]) {
18				ll.add(coin[i]);
19				Combination(coin,amount-coin[i],ans,ll,i+1);
20				ll.remove(ll.size()-1);
21			}
22		}
23	}
24    // public static boolean isvalid(int n, int i,int[]arr){
25    //     for(int j=i;j<arr.length;j++){
26    //         if(arr[j]==n){
27    //             return true;
28    //         }
29    //     }
30    //     return false;
31    // }
32}