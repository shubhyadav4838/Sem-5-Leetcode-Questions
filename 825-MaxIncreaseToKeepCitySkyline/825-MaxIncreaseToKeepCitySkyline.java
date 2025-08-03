// Last updated: 3/8/2025, 11:56:36 pm
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] arr) {
        int[] row=new int[arr.length];
        int[] col=new int[arr.length];
        int ans =0;
        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr.length;c++){
                row[r]=Math.max(row[r],arr[r][c]);
                col[c]=Math.max(col[c],arr[r][c]);
            }
        }
        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr.length;c++){
                int val=Math.min(row[r],col[c]);
                if(arr[r][c]<val){
                    ans+=val-arr[r][c];
                }
            }
        }
        return ans;
    }
}