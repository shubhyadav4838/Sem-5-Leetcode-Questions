// Last updated: 21/11/2025, 3:29:30 pm
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        return occur(nums,queries,x);
    }
    public int[] occur(int[] arr, int[] query, int x){
        int[] ans = new int[query.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        int ocur = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=x)continue;
            ocur++;
            map.put(ocur,i);
        }
        for(int i=0;i<query.length;i++){
            if(map.containsKey(query[i])){
                ans[i] = map.get(query[i]);
            }else{
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}