// Last updated: 3/8/2025, 11:58:17 pm
class Solution {
    public int countSegments(String s) {
        return Count(s);
    }
    public int Count(String s){
        if(s.length()==0){
            return 0;
        }else if(s.length()==1 && s.charAt(0)!=32){
            return 1;
        }
        int val=-1;
        int count=0;
        for(int i=0;i<s.length();i++){
           if(val==-1 || val==0){
            if(s.charAt(i)!=32){
                val=1;
                count++;
            }
           }
           else if(val==1){
            if(s.charAt(i)==32 || i==s.length()-1){
                val=0;
                
            }
            
           }
        }
        return count;
       
    }
}