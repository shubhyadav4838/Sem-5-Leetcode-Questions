// Last updated: 4/8/2025, 12:01:53 am
class Solution {
    public int strStr(String haystack, String needle) {
        return findOccurence(haystack,needle);
    }
    public static int findOccurence(String ques, String ans){
        if(ques.equals(ans))return 0;
        int len = ans.length();
        for(int i=0;i<=ques.length()-len;i++){
            String s = ques.substring(i,i+len);
            if(s.equals(ans))return i;
        }
        return -1;
    }

}