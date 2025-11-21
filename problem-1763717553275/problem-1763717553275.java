// Last updated: 21/11/2025, 3:02:33 pm
class Solution {
    public int distributeCandies(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        return Math.min(set.size(),arr.length/2);
    }
}