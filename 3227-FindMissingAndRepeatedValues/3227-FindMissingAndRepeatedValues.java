// Last updated: 3/8/2025, 11:53:33 pm
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        return MissingNumber(grid);
    }
    public static int[] MissingNumber(int[][]arr){
        int []ans = new int[arr.length*arr.length+1];
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr.length;col++){
                ans[arr[row][col]]+=1;
            }
        }
        int[] result = new int[2];
        for(int i=1;i<ans.length;i++){
            if(ans[i]==0){
                result[1]=i;
            }else if(ans[i]==2){
                result[0]=i;
            }
        }
        return result;
    }
}