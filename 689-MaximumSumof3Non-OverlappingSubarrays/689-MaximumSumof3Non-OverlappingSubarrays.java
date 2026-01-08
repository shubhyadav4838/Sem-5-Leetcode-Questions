// Last updated: 8/1/2026, 8:23:01 pm
1class Solution {
2    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
3        int n = nums.length;
4
5        int[] sums = new int[n - k + 1];
6        int currentSum = 0;
7        for (int i = 0; i < n; i++) {
8            currentSum += nums[i];
9            if (i >= k) currentSum -= nums[i - k];
10            if (i >= k - 1) sums[i - k + 1] = currentSum;
11        }
12
13        int[][] dp = new int[4][sums.length];
14
15        for (int j = 1; j <= 3; j++) { 
16            for (int i = 0; i < sums.length; i++) {
17                int skip = (i > 0) ? dp[j][i - 1] : 0;
18                int take = sums[i];
19                if (j > 1) {
20                    if (i >= k) {
21                        take += dp[j - 1][i - k];
22                    } else {
23                        take = 0; 
24                    }
25                }
26                
27                dp[j][i] = Math.max(skip, take);
28            }
29        }
30
31        int[] ans = new int[3];
32        int currIdx = sums.length - 1;
33        
34        for (int j = 3; j >= 1; j--) {
35            while (currIdx > 0) {
36                int takeVal = sums[currIdx];
37                if (j > 1) {
38                   if (currIdx - k >= 0) takeVal += dp[j - 1][currIdx - k];
39                   else takeVal = -1;
40                }
41 
42                if (dp[j][currIdx - 1] == dp[j][currIdx]) {
43                    currIdx--;
44                } else {
45                    break; 
46                }
47            }
48            
49            ans[j - 1] = currIdx;
50            currIdx = currIdx - k; 
51        }
52        
53        return ans;
54    }
55}