// Last updated: 9/2/2026, 1:18:13 am
1class Solution {
2    public int maxFrequency(int[] nums, int k) {
3        HashMap<Integer,Integer> map = new HashMap<>();
4        int countk = 0;
5        int max = 0;
6        for(int x : nums){
7            if(x==k){
8                countk++;
9            }else{
10                int curr = map.getOrDefault(x,0)-countk;
11                curr = Math.max(1,curr+1);
12                map.put(x,curr+countk);
13                max = Math.max(max,curr);
14            }
15        }
16        return countk+max;
17    }
18}