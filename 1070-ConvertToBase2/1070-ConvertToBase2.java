// Last updated: 3/8/2025, 11:55:38 pm
class Solution {
    public String baseNeg2(int n) {
        if(n==0) return "0";

        StringBuilder sb = new StringBuilder();

        while(n!=0){
            int rem = n%-2;
            n/=-2;

            if(rem <0){
                rem+=2;
                n++;
            }

            sb.append(rem);
        }

        return sb.reverse().toString();
    }
}