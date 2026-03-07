// Last updated: 7/3/2026, 11:55:43 am
1
2class Solution {
3    public int minimumDifference(int[] nums) {
4        int n = nums.length / 2;
5        int totalSum = 0;
6        for (int num : nums) {
7            totalSum += num;
8        }
9
10        List<Integer>[] left = new ArrayList[n + 1];
11        List<Integer>[] right = new ArrayList[n + 1];
12        for (int i = 0; i <= n; i++) {
13            left[i] = new ArrayList<>();
14            right[i] = new ArrayList<>();
15        }
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
40        for (int i = 0; i <= n; i++) {
41            List<Integer> rList = right[n - i];
42            
43            for (int a : left[i]) {
44                int bTarget = targetSum - a;
45                
46                int low = 0;
47                int high = rList.size() - 1;
48                
49                while (low <= high) {
50                    int mid = low + (high - low) / 2;
51                    if (rList.get(mid) == bTarget) {
52                        low = mid;
53                        break;
54                    } else if (rList.get(mid) < bTarget) {
55                        low = mid + 1;
56                    } else {
57                        high = mid - 1;
58                    }
59                }
60                
61                int pos = low;
62                
63                if (pos < rList.size()) {
64                    int b = rList.get(pos);
65                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
66                }
67                
68                if (pos > 0) {
69                    int b = rList.get(pos - 1);
70                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
71                }
72            }
73        }
74
75        return minDiff;
76    }
77}