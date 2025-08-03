// Last updated: 3/8/2025, 11:53:18 pm
class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(prodOfDigit(n)%t==0){
                return n;
            }
            n++;
        }
    }
    public int prodOfDigit(int n){
        int prod = 1;
        while(n!=0){
            int temp = n%10;
            prod*=temp;
            n/=10;
        }
        return prod;
    }
}