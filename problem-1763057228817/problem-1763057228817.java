// Last updated: 13/11/2025, 11:37:08 pm
class Solution {
    public int maxOperations(String s) {
        return operation(s);
    }
    public static int operation(String s) {
		char[] arr = new char[s.length()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = s.charAt(i);
		}
		int count = 0;
		int sum = 0;
		int i = 0;
		while(i<s.length()) {
			
			while(i<s.length() && arr[i]=='1') {
				count++;
				i++;
			}
			boolean flag = false;
			while(i<s.length() && arr[i]=='0') {
				flag = true;
				i++;
			}
			
			if(flag) {
				sum+=count;
				
			}
			if(i>=s.length()) {
				break;
			}
		}
		return sum;
	}

}