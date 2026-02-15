// Last updated: 16/2/2026, 1:59:56 am
class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> mp = new HashMap<>();
        
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        // cnt will track if characters of t is in current window of s
        int cnt = 0;

        for(int k=0;k<t.length();k++) {
            mp.put(t.charAt(k), mp.getOrDefault(t.charAt(k), 0)+1);
        }

        while(j<s.length()) {
            char ch = s.charAt(j);

            if(mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
                if(mp.get(ch)>=0) {
                    cnt++;
                }
            }

            while(cnt == t.length()) {
                if(j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    start = i;
                }

                char leftChar = s.charAt(i);
                if(mp.containsKey(leftChar)) {
                    mp.put(leftChar, mp.get(leftChar) + 1);
                    if(mp.get(leftChar)>0) {
                        cnt--;
                    }
                }
                i++;
            }
            j++;
        }

        if(minLength==Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLength);
    }
}