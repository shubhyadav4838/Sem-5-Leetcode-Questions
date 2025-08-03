// Last updated: 3/8/2025, 11:53:12 pm
class Solution {
    public int smallestNumber(int n) {
        return AllSet(n);
        
    }
    public int AllSet(int n){
        int v = 2;
        int ans = 1;
        while(n>1){
            ans+=v;
            v*=2;
            n/=2;
        }
        return ans;
    }
}