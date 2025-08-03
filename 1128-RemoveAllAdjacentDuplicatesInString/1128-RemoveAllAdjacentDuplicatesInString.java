// Last updated: 3/8/2025, 11:55:29 pm
class Solution {
    public String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        int top = -1;
        int ind = 0;
        while(ind < s.length()){
            if(top == -1 || cs[top] != cs[ind]){
                top += 1;
                cs[top] = cs[ind];
            }
            else
                top -= 1;
            ind += 1;
        }
        return new String(cs, 0, top + 1);
    }
}