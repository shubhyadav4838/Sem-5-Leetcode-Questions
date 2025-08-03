// Last updated: 3/8/2025, 11:58:39 pm
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       return RansonNote(ransomNote, magazine);
    }
    public boolean RansonNote(String r, String m){
        int[] ran = new int[26];
        for(int i=0;i<r.length();i++){
            char word = r.charAt(i);
            ran[word-97]+=1;
        }

        int[] mag = new int[26];
        for(int i=0;i<m.length();i++){
            char word = m.charAt(i);
            mag[word-97]+=1;
        }

        for(int i=0;i<26;i++){
            if(ran[i]>mag[i]){
                return false;
            }
        }
        return true;

    }
}