// Last updated: 8/1/2026, 2:24:16 pm
1class Solution {
2    public static int maximizeWin(int[] arr, int k) {
3      
4        if (arr.length == 1 || arr.length == 2 || k >= arr[arr.length - 1] - arr[0]) {
5            return arr.length;
6        }
7
8        int ans = 0;
9        int n = arr.length;
10        int[] dp = new int[n];
11        
12        Arrays.fill(dp, -1);
13        for (int i = 0; i < n; i++) {
14            if (i > 0 && arr[i] == arr[i - 1]) {
15                dp[i] = dp[i - 1]; 
16                continue;
17            }
18            search(arr, arr[i] + k, i, n - 1, dp);
19        }
20
21        int[] pre = new int[n + 1]; 
22        
23        for (int i = n - 1; i >= 0; i--) {
24            int currentSegmentLen = dp[i] - i + 1;
25            pre[i] = Math.max(currentSegmentLen, pre[i + 1]);
26        }
27
28        for (int i = 0; i < n; i++) {
29            int len1 = dp[i] - i + 1;
30            
31            int nextIndex = dp[i] + 1;
32            int len2 = 0;
33            
34            if (nextIndex < n) {
35                len2 = pre[nextIndex];
36            }
37            
38            ans = Math.max(ans, len1 + len2);
39        }
40
41        return ans;
42    }
43
44   
45    private static int search(int[] arr, int item, int si, int ei, int[] dp) {
46        int ans = 0;
47        int start = si;
48        if (dp[si] != -1) {
49            return dp[si];
50        }
51        while (si <= ei) {
52            int mid = (si + ei) / 2;
53            if (arr[mid] <= item) {
54                ans = mid;
55                si = mid + 1;
56            } else {
57                ei = mid - 1;
58            }
59        }
60        return dp[start] = ans;
61    }
62}