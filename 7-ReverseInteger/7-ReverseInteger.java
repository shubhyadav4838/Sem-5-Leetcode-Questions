// Last updated: 4/8/2025, 12:02:23 am
class Solution {
    public int reverse(int x) {
        long n = 0;
        while(x!=0){
            int i = x%10;
            n = n*10+i;
            x/=10;
        }
        return (n< Integer.MIN_VALUE|| n> Integer.MAX_VALUE) ? 0 : (int) n;
        
    }
    
}