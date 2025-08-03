// Last updated: 3/8/2025, 11:56:42 pm
class Solution {
    public String customSortString(String order, String s) {

        int[] count = new int[26];
        Arrays.fill(count, 0);
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            for(int j=0; j<count[c - 'a']; j++){
                builder.append(c);
            }
            count[c - 'a'] = 0;
        }

        for(char c='a'; c<='z'; c++){
            for(int j=0; j<count[c - 'a']; j++){
                builder.append(c);
            }
        }
        return builder.toString();
    }
}