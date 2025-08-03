// Last updated: 3/8/2025, 11:53:05 pm
class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        return ZigZag(grid);
    }
    public List<Integer> ZigZag(int[][]arr){
        List<Integer> ll = new ArrayList<>();
        for(int row = 0;row<arr.length; row++){
            if(row%2==0){
                for(int col = 0; col<arr[0].length; col++){
                    if(col%2==0){
                        ll.add(arr[row][col]);
                    }
                }
            }else{
                for(int col = arr[0].length-1; col>=0; col--){
                    if(col%2!=0){
                        ll.add(arr[row][col]);
                    }
                }
            } 
        }
        return ll;
    }
}