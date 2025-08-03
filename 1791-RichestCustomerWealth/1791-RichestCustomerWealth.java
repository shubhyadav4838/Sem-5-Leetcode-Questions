// Last updated: 3/8/2025, 11:54:35 pm
class Solution {
    public int maximumWealth(int[][] accounts) {

        int i,j,sum=0;
        for(i=0;i<accounts.length;i++){
            int sum2=0;
            for(j=0;j<accounts[i].length;j++){
                sum2+=accounts[i][j];

            }
            sum=Math.max(sum,sum2);
        }
        return sum;
    }
}
