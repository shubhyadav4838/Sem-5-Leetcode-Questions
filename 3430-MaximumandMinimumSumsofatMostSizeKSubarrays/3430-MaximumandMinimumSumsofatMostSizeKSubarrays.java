// Last updated: 20/1/2026, 7:37:23 pm
1import java.util.Stack;
2
3class Solution {
4    public long minMaxSubarraySum(int[] nums, int k) {
5        int n = nums.length;
6        long totalSum = 0;
7
8        // 1. Get ranges for Minimums
9        int[] prevMin = new int[n];
10        int[] nextMin = new int[n];
11        getRanges(nums, prevMin, nextMin, true); // true = finding Minimums
12
13        // 2. Get ranges for Maximums
14        int[] prevMax = new int[n];
15        int[] nextMax = new int[n];
16        getRanges(nums, prevMax, nextMax, false); // false = finding Maximums
17
18        // 3. Calculate Contribution
19        for (int i = 0; i < n; i++) {
20            // Distance to boundaries
21            long leftMin = i - prevMin[i];
22            long rightMin = nextMin[i] - i;
23            long countMin = countValidSubarrays(leftMin, rightMin, k);
24
25            long leftMax = i - prevMax[i];
26            long rightMax = nextMax[i] - i;
27            long countMax = countValidSubarrays(leftMax, rightMax, k);
28
29            long val = nums[i];
30            
31            // THE FIX: Use PLUS instead of MINUS
32            // We want Sum of Max + Sum of Min
33            totalSum += val * (countMax + countMin);
34        }
35
36        return totalSum;
37    }
38
39    // Monotonic Stack to fill prev/next arrays
40    // Handles duplicates by being Strict on one side and Non-Strict on the other
41    private void getRanges(int[] nums, int[] prev, int[] next, boolean isMin) {
42        int n = nums.length;
43        Stack<Integer> st = new Stack<>();
44
45        // Find Prev (Strict)
46        for (int i = 0; i < n; i++) {
47            while (!st.isEmpty()) {
48                if (isMin) {
49                    if (nums[st.peek()] >= nums[i]) st.pop(); // Pop if >= (Strict Min)
50                    else break;
51                } else {
52                    if (nums[st.peek()] <= nums[i]) st.pop(); // Pop if <= (Strict Max)
53                    else break;
54                }
55            }
56            prev[i] = st.isEmpty() ? -1 : st.peek();
57            st.push(i);
58        }
59
60        st.clear();
61
62        // Find Next (Non-Strict)
63        for (int i = n - 1; i >= 0; i--) {
64            while (!st.isEmpty()) {
65                if (isMin) {
66                    if (nums[st.peek()] > nums[i]) st.pop(); // Pop if > (Non-Strict Min)
67                    else break;
68                } else {
69                    if (nums[st.peek()] < nums[i]) st.pop(); // Pop if < (Non-Strict Max)
70                    else break;
71                }
72            }
73            next[i] = st.isEmpty() ? n : st.peek();
74            st.push(i);
75        }
76    }
77
78    // O(1) Math Logic to count valid subarrays where (x + y - 1 <= k)
79    // This is mathematically equivalent to the loop but runs instantly.
80    private long countValidSubarrays(long A, long B, int k) {
81        // Condition: x + y <= k + 1
82        long totalBudget = k + 1; 
83
84        if (A > B) { long temp = A; A = B; B = temp; }
85
86        // 1. Zone 1: Budget is large enough for all B options
87        long splitPoint = totalBudget - B;
88        long constantCount = Math.max(0, Math.min(A, splitPoint));
89        long ans = constantCount * B;
90
91        // 2. Zone 2: Budget restricts us (Arithmetic Series)
92        long startX = constantCount + 1;
93        long endX = Math.min(A, totalBudget - 1);
94
95        if (startX <= endX) {
96            long numTerms = endX - startX + 1;
97            long firstTerm = totalBudget - startX;
98            long lastTerm = totalBudget - endX;
99            ans += numTerms * (firstTerm + lastTerm) / 2;
100        }
101
102        return ans;
103    }
104}