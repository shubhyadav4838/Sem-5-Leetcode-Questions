// Last updated: 27/7/2026, 11:46:12 am
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int level = (int)(Math.log(label) / Math.log(2)) + 1;
        while (label > 0) {
            ans.add(label);
            int min = (1 << (level - 1));
            int max = (1 << level) - 1;
            int x = min + max - label;
            label = x / 2;
            level--;
        }
        Collections.reverse(ans);
        return ans;
    }
}