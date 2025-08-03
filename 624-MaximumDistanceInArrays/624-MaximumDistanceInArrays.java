// Last updated: 3/8/2025, 11:57:19 pm
class Solution {
    public int maxDistance(List<List<Integer>> ll) {
         int ans = 0;
        int min =ll.get(0).get(0);
        int max = ll.get(0).get(ll.get(0).size() - 1);
        for(int i=1;i<ll.size();i++){
            List<Integer> curr = ll.get(i);
            int sz = curr.size()-1;

            ans = Math.max(ans,Math.abs(min-curr.get(sz)));
            ans = Math.max(ans,Math.abs(max-curr.get(0)));
            
            min = Math.min(min,curr.get(0));
            max = Math.max(max,curr.get(sz));

        }
        return ans;
    }
   
}