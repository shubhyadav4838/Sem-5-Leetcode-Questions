// Last updated: 3/8/2025, 11:54:25 pm
class Solution {
    public int findTheWinner(int n, int k) {
        int index = findWinnerIndex(n, k);
        return index+1;
    }

    public int findWinnerIndex(int n, int k){
      
      if(n==1)
       return 0;
    

    return (findWinnerIndex(n-1, k) + k)% n;
 }
}