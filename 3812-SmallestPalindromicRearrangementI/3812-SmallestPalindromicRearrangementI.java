// Last updated: 3/8/2025, 11:52:47 pm
class Solution {
    public String smallestPalindrome(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder half=new StringBuilder();
        String middle="";
        for(int i=0;i<26;i++){
            char c=(char)('a'+i);
            if(freq[i]%2==1){
                middle=String.valueOf(c);
            }
            for(int j=0;j<freq[i]/2;j++){
                half.append(c);
            }
        }
        String anshalf=half.toString();
        String reversehalf=half.reverse().toString();
        return anshalf+middle+reversehalf;
    }
}