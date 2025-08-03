// Last updated: 3/8/2025, 11:55:06 pm
class Solution {
    public int minimumSwap(String s1, String s2) {
        return swap(s1,s2);
    }
    public static int swap(String s1, String s2) {
		int x_y = 0;
		int y_x = 0;
		for (int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i)=='x' && s2.charAt(i)=='y') {
				x_y++;
			}else if(s1.charAt(i)=='y' && s2.charAt(i)=='x') {
				y_x++;
			}
		}
		if((x_y+y_x)%2!=0) {
			return -1;
		}
		int ans = (x_y/2)+(y_x/2)+(x_y%2)+(y_x%2);
		return ans;
	}

}