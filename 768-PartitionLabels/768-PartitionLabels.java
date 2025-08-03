// Last updated: 3/8/2025, 11:56:49 pm
class Solution {
    public List<Integer> partitionLabels(String s) {
         List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];

        // Step 1: Record the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Find the partitions
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}