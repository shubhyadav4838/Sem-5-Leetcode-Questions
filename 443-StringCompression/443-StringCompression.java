// Last updated: 3/8/2025, 11:58:11 pm
class Solution {
    public int compress(char[] chars) {
        return compressString(chars);
    }
    public static int compressString(char[] arr) {
		int i=0;
		int j=0;
		while(j<arr.length) {
			int count=1;
			while(j<arr.length-1 && arr[j]==arr[j+1]) {
				j++;
				count++;
			}
		
			i++;
			if(count>1) {
				if(count<10) {
					arr[i]=(char)(count+'0');
                    i++;
				}else {
					int len=findLen(count);
					int div=(int)Math.pow(10, len-1);
					while(div>0) {

						arr[i]=(char)(count/div+'0');
						count=count%div;
						div/=10;
						i++;
					}
				}
			}
			j++;
			if(j<arr.length)arr[i]=arr[j];
		
			
		}
		return i;
	}
	public static int findLen(int n) {
		int len=0;
		while(n>0) {
			n=n/10;
			len++;
		}
		return len;
	}
}