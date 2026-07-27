// Last updated: 27/7/2026, 11:44:11 am
class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        
        int globalMax = 0;
        
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                if (a == b || freq[a] == 0 || freq[b] == 0) continue;
                
                
                int currentSum = 0;
                int minorCount = 0; 
                int remainingMinor = freq[b]; 
                
                for (char c : s.toCharArray()) {
                    int val = c - 'a';
                    
                    if (val == a) currentSum++;
                    if (val == b) {
                        currentSum--;
                        minorCount++;
                        remainingMinor--;
                    }
                    
                    if (minorCount > 0) {
                        globalMax = Math.max(globalMax, currentSum);
                    }
                    
                    if (currentSum < 0 && remainingMinor > 0) {
                        currentSum = 0;
                        minorCount = 0;
                    }
                }
            }
        }
        return globalMax;
    }
}