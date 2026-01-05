// Last updated: 5/1/2026, 5:27:00 pm
1class Solution {
2    public boolean isGoodArray(int[] nums) {
3        int result = nums[0];
4        
5        for (int num : nums) {
6            result = gcd(result, num);
7            
8            if (result == 1) {
9                return true;
10            }
11        }
12        
13        return result == 1;
14    }
15    
16    private int gcd(int a, int b) {
17        while (b != 0) {
18            int temp = b;
19            b = a % b;
20            a = temp;
21        }
22        return a;
23    }
24}