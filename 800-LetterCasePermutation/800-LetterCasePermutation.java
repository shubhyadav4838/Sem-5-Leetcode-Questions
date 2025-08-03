// Last updated: 3/8/2025, 11:56:44 pm
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String>ls = new ArrayList<>();
        lettercase(s,"",ls,0);
        return ls;
    }
    public  void lettercase(String ques,String ans, List<String>ls,int idx){
        if(idx==ques.length()){
            ls.add(ans);
            return;
        }
        char ch = ques.charAt(idx);
        if(ch>='0'&&  ch<='9' ){
            lettercase(ques,ans+ch,ls,idx+1);
        }else{
            lettercase(ques,ans+ch,ls,idx+1);
            lettercase(ques,ans+getOtherCase(ch),ls,idx+1);
        }
    }
    private char getOtherCase(char current) {
        return (char)(current >= 'a' ? current - 32 : current + 32);
    }
    
}