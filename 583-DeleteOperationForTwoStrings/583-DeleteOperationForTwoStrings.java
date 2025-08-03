// Last updated: 3/8/2025, 11:57:24 pm
class Solution {
    public int minDistance(String word1, String word2) {
        return MakeSame(word1, word2);
    }
    public static int MakeSame(String a, String b){
        int [][]arr = new int[a.length()+1][b.length()+1];
        for(int row =1; row<arr.length; row++){
            for(int col=1;col<arr[0].length;col++){
               if(b.charAt(col-1)==a.charAt(row-1)) {
            	   arr[row][col]=arr[row-1][col-1]+1;
               }else {
            	   arr[row][col]=Math.max(arr[row-1][col], arr[row][col-1]);
               }
            }
        }
        int val= arr[arr.length-1][arr[0].length-1];
        return a.length()+b.length()-2*val;

    }
}