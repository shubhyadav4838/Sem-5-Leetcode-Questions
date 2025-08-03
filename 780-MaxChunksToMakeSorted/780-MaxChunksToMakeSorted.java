// Last updated: 3/8/2025, 11:56:47 pm
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max=0,ans=0;
        for(int i=0;i<arr.length;i++){
                max=Math.max(arr[i],max);
                if(max==i){
                    ans++;
                }
        }
        return ans;
    }
}
