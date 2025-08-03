// Last updated: 3/8/2025, 11:55:05 pm
class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] lastseen=new int[3];
        Arrays.fill(lastseen,-1);
        int count=0;
        for(int i=0;i<s.length();i++){
            lastseen[s.charAt(i)-'a']=i;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                count=count+(1+Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2])));
            }
        }
        return count;
    }
}