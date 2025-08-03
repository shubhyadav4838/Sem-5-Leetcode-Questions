// Last updated: 3/8/2025, 11:58:50 pm
public class Solution {
    public int integerBreak(int n) {

        if(n==2) return 1;
        if(n==3) return 2;
        int prod = 1;
        while(n>4){
            prod*=3;
            n-=3;
        }
        prod*=n;
        
        return prod;
    }
}