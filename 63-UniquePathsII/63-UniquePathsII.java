// Last updated: 23/2/2026, 4:03:21 pm
1class Solution {
2    public int uniquePathsWithObstacles(int[][] arr) {
3        if(arr[0][0]==1)return 0;
4            
5        arr[0][0] = 1;
6        for(int i = 1; i<arr.length; i++){
7            if(arr[i][0]==1)arr[i][0] = 0;
8            else arr[i][0] = arr[i-1][0];
9        }
10
11        for(int i = 1; i<arr[0].length; i++){
12            if(arr[0][i]==1)arr[0][i] = 0;
13            else arr[0][i] = arr[0][i-1];
14        }
15
16        for(int i = 1; i<arr.length; i++){
17            for(int j = 1; j<arr[0].length ; j++){
18                if(arr[i][j]==1)arr[i][j] = 0;
19                else{
20                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
21                }
22            }
23        }
24        return arr[arr.length-1][arr[0].length-1];
25    }
26}