// Last updated: 4/8/2025, 12:02:16 am
class Solution {
    public String intToRoman(int num) {
        return convert(num);
    }
   public static String convert(int n){
		StringBuilder sb = new StringBuilder();
		while(n>0) {
			if(n>=1000) {
				sb.append('M');
				n-=1000;
			}else if(n>=900) {
				sb.append("CM");
				n-=900;
			}else if(n>=500) {
				sb.append("D");
				n-=500;
			}else if(n>=400) {
				sb.append("CD");
				n-=400;
			}else if(n>=100) {
				sb.append("C");
				n-=100;
			}else if(n>=90) {
				sb.append("XC");
				n-=90;
			}else if(n>=50) {
				sb.append("L");
				n-=50;
			}else if(n>=40) {
				sb.append("XL");
				n-=40;
			}else if(n>=10) {
				sb.append("X");
				n-=10;
			}else if(n>=9) {
				sb.append("IX");
				n-=9;
			}else if(n>=5) {
				sb.append("V");
				n-=5;
			}else if(n>=4) {
				sb.append("IV");
				n-=4;
			}else {
				sb.append("I");
				n-=1;
			}
		}
		String ans = sb.toString();
		return ans;      
	}
}