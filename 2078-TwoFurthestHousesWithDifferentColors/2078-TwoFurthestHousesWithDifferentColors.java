// Last updated: 20/4/2026, 9:48:43 pm
1class Solution {
2    public int maxDistance(int[] arr) {
3        int ans = 0;
4        int n = arr.length;
5        if(arr[0]!=arr[n-1]){
6            return n-1;
7        }
8        for(int i = 1;i<arr.length-1; i++){
9            if(arr[i]!=arr[0]){
10                ans = Math.max(ans,i);
11            }
12            if(arr[i]!=arr[n-1]){
13                ans = Math.max(n-i-1,ans);
14            }
15        }
16        return ans;
17        
18    }
19}