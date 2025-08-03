// Last updated: 4/8/2025, 12:02:24 am
class Solution {
    public String convert(String s, int numRows) {
        return ZigZag(s, numRows);
    }
    public static String ZigZag(String word,int row) {
        if(row==1){
            return word;
        }
		String s = "";
		boolean flag ;
		for(int i=0; i<row; i++){
			flag = true;
			int r = 0;
			for(int j = 0; j<word.length(); j++) {
//				System.out.println(r);
				if(r==i) {
					
					s = s+word.charAt(j);
					
				}
				if(flag) {
				  r++;
				}else {
					r--;
				}
				if(r<1) {
					flag = true;
				}else if(r>row-2) {
					flag = false;
				}
			}
			
		}
		return s;
	}
}