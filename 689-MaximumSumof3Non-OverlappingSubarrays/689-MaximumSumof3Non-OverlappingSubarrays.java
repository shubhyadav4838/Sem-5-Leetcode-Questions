// Last updated: 9/1/2026, 12:21:02 pm
1class Solution {
2    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
3
4        int n = nums.length;
5        int[] sums = new int[n - k + 1];
6        int currentWindowSum = 0;
7        
8        for (int i = 0; i < nums.length; i++) {
9            currentWindowSum += nums[i];
10            if (i >= k) {
11                currentWindowSum -= nums[i - k];
12            }
13            if (i >= k - 1) {
14                sums[i - k + 1] = currentWindowSum;
15            }
16        }
17
18        
19        int maxOne = 0;
20        int bestIdxOne = 0;
21
22        
23        int maxTwo = 0;
24        int[] bestIdxTwo = {0, k}; 
25
26        
27        int maxThree = 0;
28        int[] bestIdxThree = {0, k, 2 * k}; 
29
30
31        for (int i = 2 * k; i < sums.length; i++) {
32            int idx1 = i - 2 * k; 
33            int idx2 = i - k;     
34            int idx3 = i;         
35
36            if (sums[idx1] > maxOne) {
37                maxOne = sums[idx1];
38                bestIdxOne = idx1;
39            }
40
41            if (maxOne + sums[idx2] > maxTwo) {
42                maxTwo = maxOne + sums[idx2];
43                bestIdxTwo = new int[]{bestIdxOne, idx2};
44            }
45
46            if (maxTwo + sums[idx3] > maxThree) {
47                maxThree = maxTwo + sums[idx3];
48                bestIdxThree = new int[]{bestIdxTwo[0], bestIdxTwo[1], idx3};
49            }
50        }
51
52        return bestIdxThree;
53    }
54}