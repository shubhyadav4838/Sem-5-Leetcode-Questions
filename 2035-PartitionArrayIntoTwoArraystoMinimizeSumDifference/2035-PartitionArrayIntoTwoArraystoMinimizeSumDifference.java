// Last updated: 7/3/2026, 11:50:54 am
1class Solution {
2    public int minimumDifference(int[] nums) {
3        int n = nums.length / 2;
4        int totalSum = 0;
5        for (int num : nums) {
6            totalSum += num;
7        }
8
9        List<Integer>[] left = new ArrayList[n + 1];
10        List<Integer>[] right = new ArrayList[n + 1];
11        for (int i = 0; i <= n; i++) {
12            left[i] = new ArrayList<>();
13            right[i] = new ArrayList<>();
14        }
15
16       
17        for (int mask = 0; mask < (1 << n); mask++) {
18            int sz = 0;
19            int lSum = 0;
20            int rSum = 0;
21            
22            for (int i = 0; i < n; i++) {
23                if ((mask & (1 << i)) != 0) {
24                    sz++;
25                    lSum += nums[i];
26                    rSum += nums[i + n];
27                }
28            }
29            left[sz].add(lSum);
30            right[sz].add(rSum);
31        }
32
33        for (int i = 0; i <= n; i++) {
34            Collections.sort(right[i]);
35        }
36
37        int minDiff = Integer.MAX_VALUE;
38        int targetSum = totalSum / 2;
39
40       
41        for (int i = 0; i <= n; i++) {
42            List<Integer> rList = right[n - i];
43            
44            for (int a : left[i]) {
45                int bTarget = targetSum - a;
46                
47                
48                int pos = Collections.binarySearch(rList, bTarget);
49                if (pos < 0) {
50                    pos = -(pos + 1); 
51                }
52                
53                
54                if (pos < rList.size()) {
55                    int b = rList.get(pos);
56                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
57                }
58                
59               
60                if (pos > 0) {
61                    int b = rList.get(pos - 1);
62                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
63                }
64            }
65        }
66
67        return minDiff;
68    }
69}