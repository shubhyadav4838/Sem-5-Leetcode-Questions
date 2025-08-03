// Last updated: 3/8/2025, 11:58:43 pm
class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int c = a&b;
            a^=b;
            b = c<<1;
        }
        return a; 
    }
}