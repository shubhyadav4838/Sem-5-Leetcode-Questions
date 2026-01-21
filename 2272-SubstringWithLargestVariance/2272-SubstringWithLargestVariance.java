// Last updated: 21/1/2026, 11:13:05 pm
1class Solution {
2    public int largestVariance(String s) {
3        int[] freq = new int[26];
4        for (char c : s.toCharArray()) freq[c - 'a']++;
5        
6        int globalMax = 0;
7        
8        for (int a = 0; a < 26; a++) {
9            for (int b = 0; b < 26; b++) {
10                if (a == b || freq[a] == 0 || freq[b] == 0) continue;
11                
12                
13                int currentSum = 0;
14                int minorCount = 0; 
15                int remainingMinor = freq[b]; 
16                
17                for (char c : s.toCharArray()) {
18                    int val = c - 'a';
19                    
20                    if (val == a) currentSum++;
21                    if (val == b) {
22                        currentSum--;
23                        minorCount++;
24                        remainingMinor--;
25                    }
26                    
27                    if (minorCount > 0) {
28                        globalMax = Math.max(globalMax, currentSum);
29                    }
30                    
31                    if (currentSum < 0 && remainingMinor > 0) {
32                        currentSum = 0;
33                        minorCount = 0;
34                    }
35                }
36            }
37        }
38        return globalMax;
39    }
40}