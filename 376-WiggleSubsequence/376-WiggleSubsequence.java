// Last updated: 29/3/2026, 1:33:06 pm
1class Solution {
2    public int wiggleMaxLength(int[] arr) {
3        if(arr.length==1)return 1;
4    	int[] dp = new int[arr.length];
5    	Arrays.fill(dp,-1);
6        int i=0;
7        while(i<arr.length-1 && arr[i]==arr[i+1])i++;
8    	
9        return wiggle(0,i,1,arr,dp);
10        // return wiggleBU(arr);
11        
12    }
13
14    public static int wiggleBU(int[] arr){
15        if(arr.length==1){
16            return 1;
17        }
18        int up = 1;
19        int down = 1;
20        for(int i=1;i<arr.length;i++){
21            if(arr[i]>arr[i-1]){
22                up = down+1;
23            }else if(arr[i]<arr[i-1]){
24                down = up+1;
25            }
26        }
27        return Math.max(up,down);
28    }
29
30
31
32
33   public static int wiggle(int diff, int i, int len, int[] arr, int[] dp) {
34		while (i < arr.length - 1 && arr[i] == arr[i + 1])
35			i++;
36		if (i >= arr.length - 1) {
37			return dp[i] = len;
38
39		}
40		int a = 0;
41		int b = 0;
42
43		if (dp[i] != -1) {
44			return dp[i];
45		}
46
47		if (diff <= 0 && arr[i + 1] > arr[i]) {
48			a = wiggle(arr[i + 1] - arr[i], i + 1, len + 1, arr, dp);
49		}
50		
51		if (diff >= 0 && arr[i + 1] < arr[i]) {
52			a = Math.max(a, wiggle(arr[i + 1] - arr[i], i + 1, len + 1, arr, dp));
53		}
54		b = wiggle(diff, i + 1, len, arr, dp);
55
56		return dp[i] = Math.max(a, b);
57	}
58}