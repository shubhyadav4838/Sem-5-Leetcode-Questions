// Last updated: 31/5/2026, 10:35:26 am
1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] arr) {
3        Arrays.sort(arr);
4        long curr = mass;
5        for(int i = 0; i<arr.length;i++){
6            if(curr>=arr[i]){
7                curr += arr[i];
8            }else{
9                return false;
10            }
11        }
12        return true;
13        
14    }
15}