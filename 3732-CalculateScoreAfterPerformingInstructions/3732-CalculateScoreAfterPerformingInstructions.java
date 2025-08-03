// Last updated: 3/8/2025, 11:52:59 pm
class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long ans=0;
        int i=0;
        int n=instructions.length;
        boolean[] isvisited=new boolean[n];
        while(i>=0 && i<n &&!isvisited[i]){
            isvisited[i]=true;
            if(instructions[i].equals("add")){
                ans+=values[i];
                i=i+1;
                
            }
                
            else if(instructions[i].equals("jump")){
                i=values[i]+i;
                
            }
        }
        return ans;
    }
}