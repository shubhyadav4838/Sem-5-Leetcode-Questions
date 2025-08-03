// Last updated: 4/8/2025, 12:02:29 am
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1)return 1;
        return check(s);
    }
    public static int check(String s){
        int lo = 0;
        int hi = 0;
        int idx = 1;
        int ans = 0;
        while(lo<s.length() && hi<s.length() && idx<s.length()){
            char item = s.charAt(idx);
            int result = repeat(hi,lo, s, item);
            if(result==-1){
                hi++;
                
            }else{
                lo = result+1;
                hi=idx;
            }
            idx++;
            ans=Math.max(ans,hi-lo+1);
        }
        return ans;
    }
    public static int repeat(int hi,int lo, String s, char item){
        for(int i=lo;i<=hi;i++){
            if(s.charAt(i)==item){
                return i;
            }

        }
        return -1;
    }
}