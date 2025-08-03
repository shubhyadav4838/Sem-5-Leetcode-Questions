// Last updated: 3/8/2025, 11:54:05 pm
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int i = 0;
        for(char ch :s.toCharArray() ){
            if(i<spaces.length && c==spaces[i]){
                sb.append(' ');
                i++;
            }
            sb.append(ch);
            c++;
        }
        return sb.toString();
    }
}