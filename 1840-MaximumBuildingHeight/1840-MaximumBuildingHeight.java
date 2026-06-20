// Last updated: 20/6/2026, 1:42:23 pm
1class Solution {
2    public static int maxBuilding(int n, int[][] arr) {
3        if(arr.length==0){
4            return n-1;
5        }
6        Arrays.sort(arr,(a,b)->a[0]-b[0]);
7        for(int i=arr.length-2;i>=0;i--){
8            if(arr[i][1]>arr[i+1][1]){
9                int dis = arr[i+1][0] -arr[i][0];
10                int height = arr[i][1] - arr[i+1][1];
11                if(height>dis){
12                    arr[i][1] = arr[i+1][1]+dis;
13                }
14            }
15            
16        }
17
18        int max = 0;
19        max = maxHeight(0,arr[0][1],arr[0][0]-1);
20        if(max<arr[0][1]){
21            arr[0][1] = max;
22        }
23        for(int i =0;i<arr.length-1;i++){
24            int res = maxHeight(arr[i][1],arr[i+1][1],arr[i+1][0]-arr[i][0]);
25            max = Math.max(max,res);
26            if(res<arr[i+1][1]){
27                arr[i+1][1] = res;
28            }
29        }
30
31        int last = maxHeight(arr[arr.length-1][1],9999999,n-arr[arr.length-1][0]);
32        max = Math.max(last,max);
33
34
35        return max;
36    }
37
38    public static int maxHeight(int a, int b, int diff){
39        int height = Math.abs(a-b);
40        if(diff<=height){
41            return diff+Math.min(a,b);
42        }
43        int max = Math.max(a,b) + ((diff-height)/2);
44        return max;
45
46    }
47}