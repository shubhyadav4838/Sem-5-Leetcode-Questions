// Last updated: 3/8/2025, 11:54:45 pm
class Solution {
    public int diagonalSum(int[][] mat) {
        int i,n=mat.length,sum=0;
        for(i=0;i<n;i++){
            sum += mat[i][i];
            sum += mat[i][n-i-1];
        }
        if(n%2==1){
            int mid=n/2;
            sum=sum-mat[mid][mid];

        }
        return sum;
            
    }
}
