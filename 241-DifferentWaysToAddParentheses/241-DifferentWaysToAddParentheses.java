// Last updated: 3/8/2025, 11:59:15 pm
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return exp(expression);
    }
   public static List<Integer> exp(String ques) {
        List<Integer> result = new ArrayList<>();
        boolean to_add = true;
        for(int i=0;i<ques.length();i++) {
        	if(ques.charAt(i)<'0') {
        		to_add = false;
        	}
        }
        if(to_add) {
        	 result.add(Integer.parseInt(ques));
        	 return result;
        }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') { 
                List<Integer> n1 = exp(ques.substring(0, i));
                List<Integer> n2 = exp(ques.substring(i + 1));
                for (int a : n1) {
                    for (int b : n2) {
                        if (ch == '+') {
                            result.add(a + b);
                        } else if (ch == '-') {
                            result.add(a - b);
                        } else {
                            result.add(a * b);
                        }
                    }
                }
            }
        }
        return result;
    }
}