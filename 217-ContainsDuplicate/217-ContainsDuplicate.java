// Last updated: 3/8/2025, 11:59:33 pm
class Solution {
    public boolean containsDuplicate(int[] nums) {
      HashSet <Integer> set = new HashSet<>();
      for (int n: nums) {
        if (set.contains(n))
            return true;
        set.add(n);
      }
      return false;
    }
}