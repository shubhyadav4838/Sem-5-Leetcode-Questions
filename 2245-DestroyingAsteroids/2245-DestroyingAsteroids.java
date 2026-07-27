// Last updated: 27/7/2026, 11:44:17 am
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] arr) {
        Arrays.sort(arr);
        long curr = mass;
        for(int i = 0; i<arr.length;i++){
            if(curr>=arr[i]){
                curr += arr[i];
            }else{
                return false;
            }
        }
        return true;
        
    }
}