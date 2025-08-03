// Last updated: 3/8/2025, 11:56:35 pm
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        for (int age : ages) {
            freq[age]++;
        }
        int req = 0;
        for (int a = 15; a <= 120; a++) {
            if (freq[a] == 0) continue;
            for (int b = (int)(0.5 * a + 8); b <= a; b++) {
                if (freq[b] == 0) continue;
                if (a == b) {
                    req += freq[a] * (freq[a] - 1);
                } else {
                    req += freq[a] * freq[b];
                }
            }
        }
        return req;
    }
}