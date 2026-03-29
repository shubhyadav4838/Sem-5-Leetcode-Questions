// Last updated: 29/3/2026, 1:51:43 pm
1class Solution {
2    public int wiggleMaxLength(int[] arr) {
3         if(arr.length==1){
4            return 1;
5        }
6        int up = 1;
7        int down = 1;
8        for(int i=1;i<arr.length;i++){
9            if(arr[i]>arr[i-1]){
10                up = down+1;
11            }else if(arr[i]<arr[i-1]){
12                down = up+1;
13            }
14        }
15        return Math.max(up,down);
16        
17    }
18}