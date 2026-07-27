// Last updated: 27/7/2026, 11:44:30 am
class Solution {
    public int numOfStrings(String[] patterns, String word) {

        int ans = 0;

        for (String str : patterns) {
            if (word.indexOf(str) != -1) {

                ans++;
            }
        }

        return ans;
    }
}