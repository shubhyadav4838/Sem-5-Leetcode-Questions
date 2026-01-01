// Last updated: 1/1/2026, 1:31:28 pm
1class Solution {
2    public int characterReplacement(String s, int k) {
3        int[] count = new int[26];
4        int maxCount = 0, left = 0, ans = 0;
5
6        for (int right = 0; right < s.length(); right++) {
7            count[s.charAt(right) - 'A']++;
8            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
9
10            while ((right - left + 1) - maxCount > k) {
11                count[s.charAt(left) - 'A']--;
12                left++;
13            }
14
15            ans = Math.max(ans, right - left + 1);
16        }
17
18        return ans;
19    }
20}