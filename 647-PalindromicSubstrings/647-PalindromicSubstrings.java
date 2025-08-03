// Last updated: 3/8/2025, 11:57:15 pm
class Solution {
    public int countSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;

        int left = 0;
        int right = 0;

        int result = 0;

        for (int i = 0; i < n; i++) {
            left = i - 1;
            right = i;

            while (right < n - 1 && charArray[right] == charArray[right + 1]) {
                right++;
            }

            result += ((right - left) * (right - left + 1)) / 2;

            i = right;

            right++;

            while (left >= 0 && right < n && charArray[left] == charArray[right]) {
                result++;
                left--;
                right++;
            }
        }

        return result;
    }
}