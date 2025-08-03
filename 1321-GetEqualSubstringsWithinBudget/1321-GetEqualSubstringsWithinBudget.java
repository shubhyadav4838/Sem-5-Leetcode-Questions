// Last updated: 3/8/2025, 11:55:08 pm
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxlen=0;
        char [] sArray=s.toCharArray();
        char [] tArray=t.toCharArray();
        for(int start=0,end=0;end<sArray.length;end++){
            maxCost-=Math.abs(sArray[end]-tArray[end]);
            while(maxCost<0){
                maxCost+=Math.abs(sArray[start]-tArray[start]);
                start++;
            }
            maxlen=Math.max(maxlen,end-start+1);
        }
        return maxlen;
    }
}