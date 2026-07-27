// Last updated: 27/7/2026, 11:44:23 am
class Solution {
    public int maxDistance(int[] arr) {
        int ans = 0;
        int n = arr.length;
        if(arr[0]!=arr[n-1]){
            return n-1;
        }
        for(int i = 1;i<arr.length-1; i++){
            if(arr[i]!=arr[0]){
                ans = Math.max(ans,i);
            }
            if(arr[i]!=arr[n-1]){
                ans = Math.max(n-i-1,ans);
            }
        }
        return ans;
        
    }
}